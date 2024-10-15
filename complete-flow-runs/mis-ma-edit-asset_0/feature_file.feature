Feature: Asset Management on MIS Portal
  As a user, I want to manage assets on the MIS portal

  Background: User Authentication
    Given User is on the MIS login page "https://mymis.geminisolutions.com/Account/Login"
    When User enters user id "webadmin" in the username field
    And User enters password "Gemini@1234" in the password field
    And User clicks on the login button
    Then User should be logged in successfully

  Scenario: Edit Asset Details
    Given User navigates to "Asset Allocation" section
    And User clicks on "Manage Assets"
    Then User should be redirected to the asset management page
    When User clicks on "Edit Asset" button
    And User changes asset type to "CPU"
    And User updates serial number to "SRN000089"
    And User clicks on the update button
    Then User should be redirected to the asset management page