Feature: Hartron TestControl Export Test Data Functionality
  As a user, I want to export test data from the TestControl screen

  Background:
    Given User is on the login page at https://athena-hartron-dev.geminisolutions.com/login
    When User selects Email option for login
    And User types Email 'sivapuja.pasupulati@geminisolutions.com'
    And User types password 'Siva@123'
    And User clicks on Login button
    And User clicks on the hamburger button
    And User clicks on Tests dropdown
    And User selects Test controls

  Scenario: Verify Export Test Data Functionality
    Given user is on TestControl screen
    When user clicks on Export test data button
    Then user should see a download button
    And user should be able to download the exported test data