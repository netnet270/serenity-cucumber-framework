Feature: Campaign new tab skin

  Scenario: Verify data after create campaign new tab skin browser skin
    Given "support" account login to qc site
    Then select client "trang@mailtothis.com"
    Then navigate to "Campaigns" menu
    And click create campaign
    And choose where you want to display your ads is "New Tab"
    And choose the position of your ads is "Skin"
    And choose your type of campaign is "Browser Skin"
    And input data campaigns to create
      | Campaign name           | Time period | Bid strategy               | Daily limit    | Max impressions by user | Delivery type | Stats tracking | Industry                    | Charge type               |
      | newtab_skin_browserskin | @time       | Automated with daily limit | By impressions | Limited                 | Accelerated   |                | FINANCE INDUSTRY: Insurance | Custom Skin with no video |

