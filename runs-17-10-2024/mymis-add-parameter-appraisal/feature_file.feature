Feature: Parameter Master Management on MIS Portal
  As a user, I want to add a new parameter to the Parameter Master

  Background:
    Given User is on the MIS login page "https://mymis.geminisolutions.com/Account/Login"
    When User enters user id "webadmin"
    And User enters password "Gemini@1234"
    And User clicks on the login button
    Then User should be redirected to the MIS homepage

  Scenario: Add a new parameter in Parameter Master
    Given User navigates to Parameter Master under Appraisal
    Then User should be redirected to the Parameter Master page
    When User clicks on the competency dropdown
    And User selects "Behavioral" from the competency dropdown
    And User enters "test123" in the parameter name field
    And User clicks on the weightage dropdown
    And User selects "3" from the weightage dropdown
    And User clicks on the Add button
    Then the new parameter should be added to the Parameter Master