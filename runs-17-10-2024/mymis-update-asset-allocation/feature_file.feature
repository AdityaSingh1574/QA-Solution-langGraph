Feature: Asset Management on MIS Portal
  As a user, I want to manage assets on the MIS portal

  Background:
    Given User is on the MIS login page "https://mymis.geminisolutions.com/Account/Login"
    When User enters user id "webadmin" in the username field
    And User enters password "Gemini@1234" in the password field
    And User clicks on the login button

  Scenario: Edit Asset Details
    Given User navigates to the Asset Allocation section
    And User selects Manage Assets option
    Then User should be redirected to the Manage Assets page
    When User selects edit asset option
    And User changes asset type to "CPU"
    And User changes serial number to "SRN000089"
    And User clicks on update asset button
    Then User should see the updated asset details