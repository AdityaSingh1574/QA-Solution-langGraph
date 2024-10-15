Feature: Apply for LNSA on MIS Portal
  As a user, I want to apply for LNSA for specific weeks

  Background:
    Given User is on the login page "https://mymis.geminisolutions.com/Account/Login"
    When User types user id "webadmin"
    And User types password "Gemini@123"
    And User clicks login button
    Then User should be redirected to the MIS homepage

  Scenario: Apply for LNSA for Week 40 and 41
    Given User navigates to apply under LNSA
    When User checks week 40 for LNSA
    And User checks week 41 for LNSA
    And User clicks submit button
    Then User should be redirected to the LNSA application page
    When User enters the reason "Required for company's quick progress" in input field
    And User clicks final submit button
    Then the LNSA application should be submitted successfully