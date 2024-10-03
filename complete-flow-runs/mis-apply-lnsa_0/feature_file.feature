Feature: Apply for LNSA on MyMIS
  As a user, I want to apply for LNSA for specific weeks

  Background:
    Given User is on the MyMIS login page "https://mymis.geminisolutions.com/Account/Login"
    When User enters user id "webadmin"
    And User enters password "Gemini@123"
    And User clicks on the login button

  Scenario: Apply for LNSA for Week 40 and 41
    Given User is redirected to the MyMIS homepage
    When User navigates to the Apply section under LNSA
    Then User is redirected to the LNSA Apply page
    When User checks the checkbox for week 40
    And User checks the checkbox for week 41
    And User clicks on the submit button
    And User enters the reason "Required for company's quick progress"
    And User clicks on the final submit button