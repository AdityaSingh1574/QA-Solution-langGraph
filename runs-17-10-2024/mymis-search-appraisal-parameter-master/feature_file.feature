Feature: Parameter Master Management in Appraisal System
  As a user, I want to manage parameters in the appraisal system

  Background:
    Given User is on the login page "https://mymis.geminisolutions.com/Account/Login"
    When User enters user id as 'webadmin'
    And User enters password as 'Gemini@1234'
    And User clicks on the login button
    Then User should be logged in successfully

  Scenario: Search Parameters in Parameter Master
    Given User navigates to Parameter Master under Appraisal
    When User selects 'April 2022' from Appraisal Cycle dropdown
    And User selects 'Canan Tower' from Location dropdown
    And User selects 'Gemini solutions' from Vertical dropdown
    And User selects 'Senior Software Engineer L2' from Designation dropdown
    And User clicks on the search button
    Then User should be redirected to the Parameter Master page