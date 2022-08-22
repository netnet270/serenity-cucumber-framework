package coccoc.AM.page.campaigns;

public class CampaignCreatePage {

    public static String xpathWhereDisplay = "//div[@data-field='placement_type'][descendant::span[text()='Choose where you want to display your ads']]//li[descendant::div[text()='%s']]";

    public static String xpathPosition = "//div[@data-field='placement_position'][descendant::span[text()='Choose the position of your ads']]//li[descendant::div[text()='%s']]";

    public static String xpathType = "//div[@data-field='campaign_type'][descendant::span[text()='Choose your type of campaign']]//li[descendant::div[text()='%s']]";
}
