package coccoc.AM.page.campaigns;

public class CampaignCreatePage {

    public final static String xpathWhereDisplay = "//div[@data-field='placement_type'][descendant::span[text()='Choose where you want to display your ads']]//li[descendant::div[text()='%s']]";

    public final static String xpathPosition = "//div[@data-field='placement_position'][descendant::span[text()='Choose the position of your ads']]//li[descendant::div[text()='%s']]";

    public final static String xpathType = "//div[@data-field='campaign_type'][descendant::span[text()='Choose your type of campaign']]//li[descendant::div[text()='%s']]";

    public final static String xpathTimePeriod = "//div[@data-field='time_period'][descendant::span[text()='Time period']]//div[contains(@class,'is-empty')]//input";

    public final static String xpathDataField = "//div[@data-field='%s']";

    public final static String xpathOptionValue = "//ul//li[text()='%s']";
}
