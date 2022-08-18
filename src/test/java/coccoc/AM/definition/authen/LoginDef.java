package coccoc.AM.definition.authen;

import coccoc.AM.steps.authen.LoginSteps;
import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class LoginDef {

    @Steps
    LoginSteps loginSteps;

    @Given("user login to qc site")
    public void user_login_to_qc_site() {
        loginSteps.openBrowser();
        loginSteps.changeLanguage("English");
        loginSteps.inputEmail("gurusupport@testing.qc");
        loginSteps.inputPass("abc123");
        loginSteps.clickBtnLogin();
        System.out.println("Login success");
    }
}
