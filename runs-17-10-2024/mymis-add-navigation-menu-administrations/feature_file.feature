Feature: Manage Navigation Menu on MyMIS
  As a user, I want to add a new navigation menu to the system

  Background:
    Given User is on the MyMIS login page "https://mymis.geminisolutions.com/Account/Login"
    When User enters user id "webadmin" in the username field
    And User enters password "Gemini@1234" in the password field
    And User clicks on the login button
    Then User should be redirected to the MyMIS homepage

  Scenario: Add a New Navigation Menu
    Given User navigates to Manage Menu under Administrations
    And User is redirected to the Manage Menu page
    When User clicks on 'Add new navigation menu' button
    And User enters "test123" as the menu name
    And User enters the action name
    And User enters the controller name
    And User enters the css class
    And User enters the menu sequence
    And User toggles select menu
    And User selects 'is link enabled' as true
    And User selects 'is delegatable' as true
    And User clicks on 'Add navigation menu' button
    Then User should be redirected to the Manage Menu page