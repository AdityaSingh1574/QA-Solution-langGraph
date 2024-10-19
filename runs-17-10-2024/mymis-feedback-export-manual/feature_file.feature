Feature: Quarterly Feedback Management on MyMIS
  As a user, I want to access and manage quarterly feedback data

  Background:
    Given User is on the MyMIS login page "https://mymis.geminisolutions.com/Account/Login"
    When User types user id "webadmin"
    And User types password "Gemini@1234"
    And User clicks login button

  Scenario: Access and Export Quarterly Feedback Data
    Given User navigates to "quaterly feedback" under ec-dc management
    When User selects the first option from financial year dropdown
    And User selects Finadvisor from Delivery council dropdown
    And User changes the number of entries to 50
    And User clicks on export button to download
    And User clicks on user manual button
    Then User should be redirected to "https://mymis.geminisolutions.com/EcDcHierarchy/NineBox"