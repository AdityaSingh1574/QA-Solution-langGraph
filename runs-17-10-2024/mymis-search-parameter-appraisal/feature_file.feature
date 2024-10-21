Feature: Parameter Master Search on MIS Portal
  As a user, I want to search for parameters in the Parameter Master section

  Background:
    Given User is on the MIS login page "https://mymis.geminisolutions.com/Account/Login"
    When User enters user id "webadmin" in the username field
    And User enters password "Gemini@1234" in the password field
    And User clicks on the login button
    Then User should be redirected to the MIS homepage

  Scenario: Search for Behavioral Parameters
    Given User navigates to Parameter Master under Appraisal
    Then User should be redirected to the Parameter Master page
    When User selects "Behavioral" from the competency dropdown
    And User selects "2017" from the year dropdown
    And User selects "Active" from the status dropdown
    And User clicks on the search button
    Then User should see the search results for Behavioral parameters