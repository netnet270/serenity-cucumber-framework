package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class CocCocdriver implements DriverSource {
    @Override
    public WebDriver newDriver() {
        try {
            Map<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("download.default_directory", "downLoadDirectory");
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("pdfjs.disabled", true);

            final DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

            WebDriverManager.chromedriver().driverVersion("104.0.5112.79").setup();
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:/program Files/CocCoc/Browser/Application/browser.exe");

            options.addArguments("--start-maximized");
            options.setExperimentalOption("prefs", chromePrefs);
            options.merge(capabilities);

            return new ChromeDriver(options);
        } catch (Exception e) {
            throw new Error(e);
        }
    }


    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
