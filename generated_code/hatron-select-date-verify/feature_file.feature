Feature: Hartron TestControl Date Filtering
  As a user, I want to filter test control records by date range

  Background:
    Given User is on the login page at https://athena-hartron-dev.geminisolutions.com/login
    When User selects Email option for login
    And User types Email 'sivapuja.pasupulati@geminisolutions.com'
    And User types password 'Siva@123'
    And User clicks on Login button
    And User clicks on the hamburger button
    And User clicks on Tests dropdown
    And User selects Test controls

  Scenario: Filter TestControl Records by Date Range
    Given user is on TestControl screen
    When user clicks on the start date selection button
    And user selects the start date
    And user clicks on the end date selection button
    And user selects the end date
    Then the records should be filtered based on the selected date range
    And user should see the filtered records count