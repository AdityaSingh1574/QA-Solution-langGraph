Feature: Client Management on MyMIS
  As a user, I want to log in and manage clients in the EC-DC management system

  Background:
    Given User is on the login page "https://mymis.geminisolutions.com/Account/Login"
    When User types user id "webadmin"
    And User types password "Gemini@1234"
    And User clicks login button
    Then User should be redirected to the dashboard

  Scenario: Add a New Client
    Given User navigates to client management under ec-dc management
    And User should be redirected to the client management page
    When User clicks on 'Add Client' button
    And User fills in the client name
    And User fills in the address
    And User fills in the city
    And User fills in the country
    And User clicks 'Add' button
    Then User should be redirected to the manage client page