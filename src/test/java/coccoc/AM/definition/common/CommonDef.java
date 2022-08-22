package coccoc.AM.common;

import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class CommonDef {

    @Steps
    Common commonSteps;

    @Then("navigate to {string} menu")
    public void navigate_to_menu(String menu) {
        commonSteps.navigateToMenu(menu);
    }
}
