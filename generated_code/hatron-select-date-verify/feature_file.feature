Feature: Hartron TestControl Date Filtering
  As a user of the TestControl screen
  I want to filter records by date range
  So that I can view specific data within a chosen time period

Scenario: Select Date Range and Verify Filtered Records
  Given user is on TestControl screen
  When user clicks on the start date selection button
  And user selects the start date
  And user clicks on the end date selection button
  And user selects the end date
  Then the system should filter the records based on the selected date range
  And user should see only records within the specified date range
  And the count of filtered records should be displayed