Feature: Access Card Management on MyMIS
  As a user, I want to manage access cards on the MyMIS system

  Background:
    Given User is on the MyMIS login page "https://mymis.geminisolutions.com/Account/Login"
    When User enters user id "webadmin" in the user id input field
    And User enters password "Gemini@1234" in the password input field
    And User clicks on the login button

  Scenario: Export, Copy, Download Excel, and Print Access Cards
    Given User is on the MyMIS homepage
    When User clicks on the export button
    And User clicks on the Copy option
    And User clicks on the Excel option
    Then User verifies if Excel "Access Cards" file is downloaded
    When User clicks on the Print button
    Then User verifies if Print "Access Cards" works correctly