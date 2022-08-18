package coccoc.AM.page.authen;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

public class LoginPage {
    public static String iconLanguage = "(//a[contains(@href,'https://testing.qc.coccoc.com/user/login')])[1]";
    public static String xpathEmail = "//form[@action='/user/login']//input[@name='email']";
    public static String xpathPassword = "//form[@action='/user/login']//input[@name='password']";
}
