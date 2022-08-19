package coccoc.AM.common;

import com.gargoylesoftware.htmlunit.ScriptException;
import javafx.beans.binding.BooleanExpression;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.*;
import java.util.List;

import static net.serenitybdd.core.environment.ConfiguredEnvironment.getConfiguration;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static org.assertj.core.api.Assertions.assertThat;

public class Common extends PageObject {

    WebElementFacade element;
    public static WebDriverWait waitExplicit;
    public static String timeOutShort = "time.short.timeout", timeOutLong = "time.long.timeout";
    public static String osName = System.getProperty("os.name");
    public static String workingDr = System.getProperty("user.dir");
    public static String platWin = "windows", platMac = "mac";
    private static final TemporalUnit SECONDS = ChronoUnit.SECONDS;

    public void openBrowser() {
        open();
        maximiseScreen();
    }

    public String getDefaultBaseUrl() {
        String baseUrl = "";
        if (isNotEmpty(getConfiguration().getBaseUrl())) {
            baseUrl = getConfiguration().getBaseUrl();
        }
        return baseUrl;
    }

    public void openBrowserWithURL(String url) {
        openUrl(url);
        maximiseScreen();
        waitForPageLoad();
    }

    public void navigateToUrl(String url) {
        getDriver().navigate().to(url);
        waitForPageLoad();
    }

    public void highlightElement(String xpath) {
        try {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='3px solid red'",
                    findBy(xpath));
        } catch (Exception e) {
        }
    }

    public void clickOnElement(String xpath) {
        highlightElement(xpath);
        element(xpath).waitUntilClickable().click();
    }

    public void sendKeyToElement(String xpath, String value) {
        highlightElement(xpath);
        element(xpath).click();
        element(xpath).clear();
        element(xpath).sendKeys(value);
    }

    public String getText(String xpath) {
        return element(xpath).getText();
    }

    public int getSize(String xpath){
        return findAll(xpath).size();
    }

    public String getAttributeValue(String xpath, String attribute) {
        return element(xpath).getAttribute(attribute);
    }

    public String getCssValue(String xpath, String css){
        waitForElementToPresent(xpath);
        highlightElement(xpath);
        return element(xpath).getCssValue(css);
    }

    // get list element
    public List<WebElementFacade> getListElement(String xpath, String values) {
        highlightElement(xpath);
        return findAll(xpath);
    }

    public void clickButton(String button, int index) {
        clickOnElement("(//button[text()='" + button + "'])[" + index + "]");
    }

    public void clickOnButton(String button) {
        clickButton(button, 1);
    }

    public void waitForPageLoad() {
        WebDriver driver = getDriver();
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

    public void maximiseScreen() {
        getDriver().manage().window().maximize();
    }

    public void closeBrowser() {
        getDriver().close();
    }

    public void quitBrowser() {
        getDriver().quit();
    }

    public void waitForVisibleTextToAppear(String xpath, String text) {
        waitForCondition().until(
                ExpectedConditions.textToBePresentInElement((WebElement) By.xpath(xpath), text)
        );
    }

    public void waitForElementPresent(String xpath) {
        waitExplicit = new WebDriverWait(getDriver(), 10);
        waitExplicit.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public WebElementFacade waitForElementToPresent(String _xPath) {
        withTimeoutOf(10, SECONDS).waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(_xPath)));
        return findBy(_xPath);
    }

    public void waitForElementNotPresent(String xpath) {
        waitExplicit = new WebDriverWait(getDriver(), 10);
        waitExplicit.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))));
    }

    public void waitForElementNotVisible(String xpath) {
        waitExplicit = new WebDriverWait(getDriver(), 10);
        waitExplicit.until(ExpectedConditions.not(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath))));
    }

    public void waitForElementClickable(String xpath){
        waitExplicit = new WebDriverWait(getDriver(), 10);
        waitExplicit.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public boolean isElementExist(String _xPath, int _TimeOutInSecond) {
        try {
            setImplicitTimeout(_TimeOutInSecond, SECONDS);
            waitForElementToPresent(_xPath);
            resetImplicitTimeout();
            return true;
        } catch (Exception e) {
            resetImplicitTimeout();
        }
        return false;
    }

    public boolean isElementExist(String _xPath) {
        return isElementExist(_xPath, 5);
    }

    public void verifyElementPresent(String _xPath, boolean _isPresent) {
        waitForPageLoad();
        assertThat(isElementExist(_xPath)).isEqualTo(_isPresent);
    }

    public boolean verifyTextPresent(String text, boolean isPresent) {
        String xpath = "";
        if (text.contains("\"")) {
            xpath = "//*[contains(text(),'" + text + "')]";
        } else {
            xpath = "//*[contains(text(),\"" + text + "\")]";
        }
        verifyElementPresent(xpath, isPresent);
        return isPresent;
    }

    public void uploadFile(String fileName, String xpath){

    }


    public void uploadFile(String folderFile, String fileName, String xpath) throws IOException, AWTException {
        highlightElement(xpath);
        String pathFile = null;

        pathFile = LoadObject.getPathFile(folderFile) + fileName;

        clickOnElement(xpath);

        StringSelection stringSelection = new StringSelection(pathFile);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        Robot robot = new Robot();
        waitABit(5000);
        if (osName.toLowerCase().contains(platWin)) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            waitABit(5000);

        } else if (osName.toLowerCase().contains(platMac)) {
            Runtime runtime = Runtime.getRuntime();
            if (getDriver().toString().toLowerCase().contains("chrome")) {
                String[] args = {"osascript", "-e", "tell app \"Chrome\" to activate"};
                runtime.exec(args);
            } else if (getDriver().toString().toLowerCase().contains("firefox")) {
                String[] args = {"osascript", "-e", "tell app \"Firefox\" to activate"};
                runtime.exec(args);
            } else {
                System.out.println("not found browser in" + osName);
            }

            waitABit(5000);
            // Open go to window
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_G);
            robot.keyRelease(KeyEvent.VK_META);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_G);
            waitABit(5000);

            // Paste the clipboard value
            robot.keyPress(KeyEvent.VK_META);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_META);
            robot.keyRelease(KeyEvent.VK_V);
            waitABit(5000);

            // Press Enter key to close the Goto window and Upload window
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            waitABit(10000);

        } else {
            System.out.println("not found OS action robot");
        }

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public String getCurrentTime(String formatDate) {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();

        final SimpleDateFormat f = new SimpleDateFormat(formatDate);
        String string = f.format(date);
        return string;
    }

    public static String getTodayByFormat(String stringFormat) {
        DateFormat day = new SimpleDateFormat(stringFormat);
        Calendar cal = Calendar.getInstance();
        return day.format(cal.getTime());
    }

    public static String addDays(String fromDate, int days, String dateFormat) {
//        fromDate = fromDate.replace("/", "-");
        SimpleDateFormat format = new SimpleDateFormat(dateFormat, Locale.US);
        Date myDate = null;
        try {
            myDate = format.parse(fromDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(myDate);
        cal.add(Calendar.DATE, days); // minus number would decrement the days
        fromDate = format.format(cal.getTime());
        return fromDate;
    }

    public String addMonth(String month, String formatDate) {
        int a = Integer.parseInt(month);
        Calendar cal = Calendar.getInstance();

        cal.add(Calendar.MONTH, a);
        Date date = cal.getTime();

        final SimpleDateFormat f = new SimpleDateFormat(formatDate);// dd/MM/yyyy
        String string = f.format(date);
        return string;
    }

    // random
    public int randomInteger() {
        Random random = new Random();
        return random.nextInt(999999);
    }


}
