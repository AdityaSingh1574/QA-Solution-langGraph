Feature: List Search Results on Amazon India
As a user, I want to search for various items on Amazon India and view the search results

Scenario: Search and List Sandals
    Given user is on the Amazon India homepage
    When user enters 'Sandals' in the search box
    And user clicks on the search button
    Then the search results for 'Sandals' should be displayed
    And user should see a list of sandals in the search results
    And user prints the names of the sandals displayed

Scenario: Search and List Shoes
    Given user is on the Amazon India homepage
    When user enters 'Shoes' in the search box
    And user clicks on the search button
    Then the search results for 'Shoes' should be displayed
    And user should see a list of shoes in the search results
    And user prints the names of the shoes displayed