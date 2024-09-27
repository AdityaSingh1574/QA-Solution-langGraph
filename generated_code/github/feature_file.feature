Feature: Search and Print Repository Names on GitHub
  As a user, I want to search for repositories on GitHub and print the names of the first 3 results

  Scenario: Print the name of first 3 repositories after searching for machine-learning
    Given user is on the landing page of the website https://github.com/
    When user clicks on the search button
    And user types "machine-learning" in the search bar
    And user clicks enter for searching
    Then user is on the results page
    And user prints the first 3 names of the results page

  Scenario: Print the name of first 3 repositories after searching for Deep-learning
    Given user is on the landing page of the website https://github.com/
    When user clicks on the search button
    And user types "Deep-learning" in the search bar
    And user clicks enter for searching
    Then user is on the results page
    And user prints the first 3 names of the results page