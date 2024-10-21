Feature: Meal Management on MIS Portal
  As a user, I want to manage meal periods, types, categories, and dishes

  Background:
    Given User is on the login page "https://mymis.geminisolutions.com/Account/Login"
    When User types user id 'webadmin'
    And User types password 'Gemini@1234'
    And User clicks login button
    Then User should be redirected to the dashboard

  Scenario: Add New Meal Period, Type, Category, and Dishes
    Given User navigates to manage under meal management
    And User is redirected to the meal management page
    When User clicks 'Add Meal Period' button
    And User enters 'test 123' in the meal period input field
    And User clicks save button under meal period tab
    And User clicks 'Add Meal Type' button
    And User enters 'test-1234' in the meal type input field
    And User clicks save button under meal type tab
    And User clicks 'Add Meal Category' button
    And User enters 'test-1234' in the meal category input field
    And User clicks save button under meal category tab
    And User clicks 'Add Meal Dishes' button
    And User enters 'test-1234' in the meal dishes input field
    And User clicks save button under meal dishes tab
    Then User should be redirected to the meal management page