Feature: Meal Package Management on MyMIS
  As a user, I want to add a new meal package to the system

  Background:
    Given User is on the MyMIS login page "https://mymis.geminisolutions.com/Account/Login"
    When User enters user id "webadmin" in the username field
    And User enters password "Gemini@1234" in the password field
    And User clicks on the login button
    Then User should be redirected to the MyMIS homepage

  Scenario: Add a New Meal Package
    Given User navigates to the Meal Management section
    And User clicks on the Meal Package option
    Then User should be redirected to the Meal Package page
    When User clicks on the 'Add new meal package' button
    And User selects 'test123' from the meal period dropdown
    And User selects 'italian' from the meal type dropdown
    And User selects 'Vegan' from the meal category dropdown
    And User clicks on the save button
    Then User should be redirected to the Meal Package listing page