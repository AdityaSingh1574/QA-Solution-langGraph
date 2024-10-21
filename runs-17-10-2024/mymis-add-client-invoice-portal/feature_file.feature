Feature: Login and Add New Client on MyMIS
  As a user, I want to log in to MyMIS and add a new client in the invoice portal

  Background: User Authentication
    Given User is on the login page "https://mymis.geminisolutions.com/Account/Login"
    When User enters user id "webadmin" in the username field
    And User enters password "Gemini@1234" in the password field
    And User clicks on the login button
    Then User should be redirected to the MyMIS homepage

  Scenario: Add New Client in Invoice Portal
    Given User is on the MyMIS homepage
    When User navigates to the invoice portal under Account portal
    Then User should be redirected to the invoice portal page
    When User clicks on the 'Add new client' button
    And User enters name "test123" in the client name input field
    And User clicks on the save button
    Then User should be redirected to the invoice report page