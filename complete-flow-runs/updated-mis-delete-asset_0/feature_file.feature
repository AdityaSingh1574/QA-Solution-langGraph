Feature: Asset Allocation Management on https://mymis.geminisolutions.com
  As a user, I want to manage asset allocations and delete assets

  Background:
    Given User is on the login page
    When User types user id 'webadmin'
    And User types password 'Gemini@1234'
    And User clicks login button

  Scenario: Delete an Asset
    Given User navigates to manage under asset allocation
    When User clicks on delete asset
    And User clicks yes to confirm
    Then User should be redirected to the Asset Management page