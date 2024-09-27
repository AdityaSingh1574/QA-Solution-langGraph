Feature: Hartron TestControl Export Test Data Functionality
  As a user of the TestControl screen
  I want to export test data
  So that I can download and use the data for further analysis

Scenario: Verify Export Test Data Functionality
  Given user is on TestControl screen
  When user clicks on Export test data button
  Then the download button should appear
  And user should be able to click on the download button to export the test data