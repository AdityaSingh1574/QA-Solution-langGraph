Feature: Employee Directory Search on MyMIS
  As a user, I want to access the Employee Directory and search for users

  Background:
    Given User is on the MyMIS login page "https://mymis.geminisolutions.com/Account/Login"
    When User enters user id "webadmin" in the username field
    And User enters password "Gemini@123" in the password field
    And User clicks on the login button
    Then User should be redirected to the MyMIS homepage

  Scenario: Search for User in Employee Directory
    Given User is on the MyMIS homepage
    When User clicks on the "Employee Directory" menu item
    Then User should be redirected to the Employee Directory page
    When User selects "25" from the entries dropdown
    And User types "User" in the search bar
    And User presses enter
    Then User should see the search results for "User"