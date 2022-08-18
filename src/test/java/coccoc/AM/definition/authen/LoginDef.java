package coccoc.AM.definition.authen;

import coccoc.AM.steps.authen.LoginSteps;
import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class LoginDef {

    @Steps
    LoginSteps loginSteps;

    @Given("{string} account login to qc site")
    public void account_login_to_qc_site(String actor) {
        loginSteps.openBrowser();
        loginSteps.changeLanguage("English");
        loginSteps.loginQCSite(actor);
        System.out.println("Login success");
    }
}
