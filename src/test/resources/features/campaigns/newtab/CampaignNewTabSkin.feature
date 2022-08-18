Feature: Campaign new tab skin
  Scenario: Verify data after create campaign new tab skin browser skin
#    Given user login to qc site
    Then select client "trang@mailtothis.com"
    Then navigate to "Campaigns" menu
    Then create campaigns with data
