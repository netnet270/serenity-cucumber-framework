package coccoc.AM.definition.campaigns;

import coccoc.AM.steps.campaigns.CampaignCreateSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;

public class CampaignCreateDef {

    @Steps
    CampaignCreateSteps campaignCreateSteps;

    @Given("choose where you want to display your ads is {string}")
    public void choose_where_you_want_to_display_your_ads_is(String whereDisplay) {
        campaignCreateSteps.selectWhereDisplay(whereDisplay);
    }

    @Given("choose the position of your ads is {string}")
    public void choose_the_position_of_your_ads_is(String position) {
        campaignCreateSteps.selectPosition(position);
    }

    @Given("choose your type of campaign is {string}")
    public void choose_your_type_of_campaign_is(String type) {
        campaignCreateSteps.selectType(type);
    }

    @Given("input data campaigns to create")
    public void input_data_campaigns_to_create(DataTable dataTable) {
        List<Map<String,String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String campaignName = row.get("Campaign name");
            String timePeriod = row.get("Time period");
            String bidStrategy = row.get("Bid strategy");
            String dailyLimit = row.get("Daily limit");
            campaignCreateSteps.inputDataToFieldWithLabel("Enter campaign name", campaignName + campaignCreateSteps.randomInteger());
            if(timePeriod.contains("@")){
                String today = campaignCreateSteps.getTodayByFormat("dd/MM/yyyy");
                timePeriod = campaignCreateSteps.addDays(today, 1, "dd/MM/yyyy");
            }
        }
    }
}
