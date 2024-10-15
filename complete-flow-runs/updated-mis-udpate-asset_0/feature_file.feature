Feature: Asset Management on https://mymis.geminisolutions.com
  As a user, I want to manage assets in the system

  Background: User Authentication
    Given User is on the login page
    When User enters user id 'webadmin'
    And User enters password 'Gemini@123'
    And User clicks on the login button

  Scenario: Edit Asset Details
    Given User navigates to manage assets under Asset Allocation
    And User is redirected to the asset management page
    When User selects edit asset option
    And User changes asset type to CPU
    And User changes serial number to SRN000089
    And User clicks update asset button
    Then User should be redirected to the asset management confirmation page