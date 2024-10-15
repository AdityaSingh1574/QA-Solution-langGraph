Feature: Employee Directory Search on MIS Portal
  As a user, I want to search for employees in the directory

  Background: User Authentication
    Given user is on the MIS login page "https://mymis.geminisolutions.com/Account/Login"
    When user enters user id "webadmin" in the username field
    And user enters password "Gemini@1234" in the password field
    And user clicks on the login button
    Then user should be redirected to the MIS homepage

  Scenario: Search for User in Employee Directory
    Given user is on the MIS homepage
    When user navigates to "Employee Directory"
    Then user should be redirected to the Employee Directory page
    When user clicks on the entries dropdown
    And user selects "25" from the dropdown
    And user enters "User" in the search bar
    And user presses enter
    Then the search results for "User" should be displayed