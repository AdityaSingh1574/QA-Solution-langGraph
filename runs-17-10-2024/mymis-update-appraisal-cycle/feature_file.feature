Feature: Manage Appraisal Cycle on MyMIS
  As a user, I want to log in and update the appraisal cycle

  Background:
    Given User is on the login page "https://mymis.geminisolutions.com/Account/Login"
    When User types user id "webadmin"
    And User types password "Gemini@1234"
    And User clicks login button
    Then User should be redirected to the MyMIS homepage

  Scenario: Update Appraisal Cycle
    Given User navigates to appraisal cycle in appraisal
    Then User should be redirected to the Appraisal Cycle page
    When User selects the appraisal month as 2023 for the first appraisal cycle
    And User clicks save button for the appraisal cycle
    Then User should be redirected to the updated Appraisal Cycle page