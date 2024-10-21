Feature: Manage Appraisal Cycles on MyMIS
  As a user, I want to log in and manage appraisal cycles

  Background:
    Given User is on the MyMIS login page "https://mymis.geminisolutions.com/Account/Login"
    When User enters user id "webadmin" in the username field
    And User enters password "Gemini@1234" in the password field
    And User clicks on the login button

  Scenario: Delete an Appraisal Cycle
    Given User is redirected to the MyMIS homepage
    When User navigates to the appraisal section
    And User clicks on appraisal cycle
    Then User is redirected to the Appraisal Cycle page
    When User selects the first appraisal cycle
    And User clicks on the delete button
    And User confirms the deletion
    Then The first appraisal cycle should be deleted