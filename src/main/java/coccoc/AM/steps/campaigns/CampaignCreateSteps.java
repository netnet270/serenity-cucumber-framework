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

}
