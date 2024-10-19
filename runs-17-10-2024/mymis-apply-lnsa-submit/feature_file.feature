Feature: Apply for LNSA on MyMIS
  As a user, I want to apply for LNSA for specific weeks

  Background:
    Given user is on the MyMIS login page "https://mymis.geminisolutions.com/Account/Login"
    When user enters user id "webadmin" in the username field
    And user enters password "Gemini@1234" in the password field
    And user clicks on the login button
    Then user should be redirected to the MyMIS homepage

  Scenario: Apply for LNSA for Week 40 and 41
    Given user is on the MyMIS homepage
    When user navigates to the LNSA Apply page
    Then user should be redirected to the LNSA Apply page
    When user checks the checkbox for Week 40
    And user checks the checkbox for Week 41
    And user clicks on the submit button
    And user enters "Required for company's quick progress" as the reason in the input field
    And user clicks on the final submit button
    Then the LNSA application should be submitted successfully