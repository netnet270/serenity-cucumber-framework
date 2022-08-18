package coccoc.AM.steps.authen;

import coccoc.AM.common.Common;
import coccoc.AM.common.LoadObject;
import coccoc.AM.page.authen.LoginPage;

public class LoginSteps extends Common {

    LoginPage loginPage;
    public void openBrowser() {
        openBrowserWithURL("https://testing.qc.coccoc.com");
    }

    public void changeLanguage(String language) {
        String languageNow = getAttributeValue(LoginPage.iconLanguage, "title");
        if(languageNow.equals(language)){
            clickOnElement(LoginPage.iconLanguage);
        }
    }

    public void loginQCSite(String actor){
        String email = LoadObject.getProperty(actor + ".name");
        String password = LoadObject.getProperty(actor + ".pwd");
        sendKeyToElement(LoginPage.xpathEmail, email);
        sendKeyToElement(LoginPage.xpathPassword, password);
        clickOnButton("Log in");
    }
}
