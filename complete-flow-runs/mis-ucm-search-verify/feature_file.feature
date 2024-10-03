Feature: Access Card Management and User Card Mapping
  As a web admin
  I want to log in, navigate to User Card Mapping, and search for a specific user
  So that I can manage access cards effectively

Scenario: Log in and search for a user in User Card Mapping
  Given I am on the login page
  When I enter the username "webadmin"
  And I enter the password "Gemini@123"
  And I click the login button
  Then I should be logged in successfully
  When I navigate to "Access Card Management"
  And I click on "User Card Mapping"
  And I type "Akshi Khattar" in the search bar
  And I press enter
  Then I should see search results for "Akshi Khattar"
  And the search results should contain relevant information for "Akshi Khattar"