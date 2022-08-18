package coccoc.AM.steps.authen;

import coccoc.AM.page.authen.LoginPage;

public class LoginSteps {

    LoginPage loginPage;
    public void openBrowser() {
        loginPage.open();
    }

    public void changeLanguage(String language) {
        String languageNow = loginPage.getLanguage();
        if(languageNow.equals(language)){
            loginPage.changeLanguage();
        }
    }

    public void inputEmail(String email) {
        loginPage.inputEmail(email);
    }

    public void inputPass(String pass) {
        loginPage.inputPwd(pass);
    }

    public void clickBtnLogin() {
        loginPage.clickLogin();
    }
}
