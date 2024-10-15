Feature: Asset Management on MIS Portal
  As a user, I want to log in and manage assets on the MIS portal

  Background:
    Given User is on the login page "https://mymis.geminisolutions.com/Account/Login"
    When User enters user id "webadmin" in the username field
    And User enters password "Gemini@1234" in the password field
    And User clicks on the login button
    Then User should be redirected to the MIS portal homepage

  Scenario: Add New Asset Type
    Given User navigates to the Asset Allocation section
    And User clicks on the Manage Assets option
    Then User should be redirected to the Asset Management page
    When User clicks on the Add new asset type button
    And User enters "testing123" in the asset type field
    And User selects "yes" from the Is temporary dropdown
    And User clicks on the add button
    Then The new asset type should be added successfully