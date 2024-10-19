Feature: Asset Management on MIS Portal
  As a user, I want to manage assets on the MIS portal

  Background: User Authentication
    Given User is on the MIS login page "https://mymis.geminisolutions.com/Account/Login"
    When User enters user id "webadmin" in the username field
    And User enters password "Gemini@1234" in the password field
    And User clicks on the login button
    Then User should be redirected to the MIS homepage

  Scenario: Add New Asset Type
    Given User is on the MIS homepage
    When User navigates to "Asset Allocation" menu
    And User clicks on "Manage Assets" option
    Then User should be redirected to the Manage Assets page
    When User clicks on "Add new asset type" button
    And User enters "testing123" in the asset type field
    And User selects "yes" for "Is temporary" option from the dropdown
    And User clicks on the "Add" button
    Then The new asset type should be added successfully