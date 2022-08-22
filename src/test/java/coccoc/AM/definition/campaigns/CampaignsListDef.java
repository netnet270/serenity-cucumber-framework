package coccoc.AM.definition.campaigns;

import coccoc.AM.steps.campaigns.CampaignsListSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class CampaignsListDef {

    @Steps
    CampaignsListSteps campaignsListSteps;
    @Given("click create campaign")
    public void click_create_campaign() {
        campaignsListSteps.clickBtnCreateCampaign();
    }
}
