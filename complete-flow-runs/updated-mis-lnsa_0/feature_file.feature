Feature: Asset Management on MIS Portal
  As a user, I want to log in and manage asset types

  Background:
    Given User is on the login page "https://mymis.geminisolutions.com/Account/Login"
    When User enters user id "webadmin" in the username field
    And User enters password "Gemini@1234" in the password field
    And User clicks on the login button
    Then User should be redirected to the MIS portal homepage

  Scenario: Add New Asset Type
    Given User navigates to the Manage Assets page under Asset Allocation
    When User clicks on the Add new asset type button
    And User types "testing123" in the asset type field
    And User selects "yes" for Is temporary option from the dropdown
    And User clicks on the add button
    Then User should be redirected to the Asset Management page