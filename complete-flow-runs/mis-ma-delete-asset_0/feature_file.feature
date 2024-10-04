Feature: Asset Allocation Management on https://mymis.geminisolutions.com
  As a user, I want to manage asset allocations and delete assets

  Background:
    Given User is on the login page
    When User types user id 'webadmin'
    And User types password 'Gemini@123'
    And User clicks login button

  Scenario: Delete an Asset
    Given User navigates to manage under asset allocation
    And User is redirected to the asset management page
    When User clicks on delete asset button
    And User clicks 'yes' on confirmation prompt
    Then User is redirected to the asset management page