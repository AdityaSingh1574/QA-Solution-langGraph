Feature: Asset Management on MIS Portal
  As a user, I want to manage assets on the MIS portal

  Background:
    Given User is on the MIS login page "https://mymis.geminisolutions.com/Account/Login"
    When User enters user id "webadmin" in the username field
    And User enters password "Gemini@123" in the password field
    And User clicks on the login button

  Scenario: Add New Asset Type
    Given User navigates to manage assets under Asset Allocation
    And User is redirected to the MIS homepage
    When User clicks on Add new asset type button
    And User enters asset type as "testing123"
    And User selects "yes" for Is temporary option from dropdown
    And User clicks add button
    Then User should be redirected to the Asset Management page