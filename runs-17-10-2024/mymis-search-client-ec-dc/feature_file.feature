  Feature: Client Management on MyMIS
    As a user, I want to access client management and search for specific clients

    Background:
      Given User is on the MyMIS login page "https://mymis.geminisolutions.com/Account/Login"
      When User types user id "webadmin"
      And User types password "Gemini@1234"
      And User clicks login button

    Scenario: Search for PIMCO client
      Given User navigates to client management under ec-dc management
      And User is redirected to the MyMIS homepage
      When User searches for "PIMCO" in the search input
      And User presses enter
      Then User is redirected to the Manage Client page