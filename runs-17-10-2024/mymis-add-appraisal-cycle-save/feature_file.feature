Feature: Manage Appraisal Cycle on MyMIS
  As a user, I want to log in and add a new appraisal cycle

  Background:
    Given User is on the login page "https://mymis.geminisolutions.com/Account/Login"
    When User types user id "webadmin"
    And User types password "Gemini@1234"
    And User clicks login button
    Then User should be redirected to the MyMIS homepage

  Scenario: Add New Appraisal Cycle
    Given User navigates to appraisal cycle in appraisal
    When User clicks 'Add New' button
    And User selects country as India from dropdown
    And User selects year as 2021 from dropdown
    And User selects month as July from dropdown
    And User clicks 'Save' button
    Then User should be redirected to the Appraisal Cycle page