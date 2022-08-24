package coccoc.AM.steps.campaigns;

import coccoc.AM.common.Common;
import coccoc.AM.page.campaigns.CampaignCreatePage;

public class CampaignCreateSteps extends Common {
    public void selectWhereDisplay(String whereDisplay) {
        clickOnElement(String.format(CampaignCreatePage.xpathWhereDisplay, whereDisplay));
    }

    public void selectPosition(String position) {
        clickOnElement(String.format(CampaignCreatePage.xpathPosition, position));
    }

    public void selectType(String type) {
        clickOnElement(String.format(CampaignCreatePage.xpathType, type));
    }

    public void inputTimePeriod(String timePeriod) {
        sendKeyToElement(CampaignCreatePage.xpathTimePeriod, timePeriod);
    }

    public void selectValueDropDownList(String field, String value){
        clickOnElement(String.format(CampaignCreatePage.xpathDataField, field));
        clickOnElement(String.format(CampaignCreatePage.xpathOptionValue, value));
    }

    public void selectBidStrategy(String bidStrategy) {
        selectValueDropDownList("bid_strategy", bidStrategy);
    }

    public void selectDailyLimit(String dailyLimit) {
        selectValueDropDownList("daily_limit_type", dailyLimit);
    }

    public void selectMaxImpressionsByUser(String maxImpressionsByUser) {
        selectValueDropDownList("is_user_impressions_limited", maxImpressionsByUser);
    }
}
