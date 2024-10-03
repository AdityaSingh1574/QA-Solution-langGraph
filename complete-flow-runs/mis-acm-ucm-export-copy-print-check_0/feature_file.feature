Feature: Access Card Management on MyMIS
  As a user, I want to manage access cards and perform various operations

  Background:
    Given User is on the MyMIS login page "https://mymis.geminisolutions.com/Account/Login"
    When User enters user id "webadmin" in the username field
    And User enters password "Gemini@123" in the password field
    And User clicks on the login button

  Scenario: Export and Print Access Cards
    Given User navigates to "Access Card management"
    And User clicks on "User card Mapping"
    Then User should be redirected to the User Card Mapping page
    When User clicks on the export button
    And User clicks on the Copy option
    And User clicks on the Excel option
    Then User verifies if Excel "Access Cards" file is downloaded
    When User clicks on the Print button
    Then User verifies if Print "Access Cards" works correctly