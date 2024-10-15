Feature: Search and Book Train Tickets on https://www.confirmtkt.com
  As a user, I want to search for train tickets and sort the results

  Scenario: Search for Train Tickets and Sort Results
    Given User is on the ConfirmTkt homepage
    When User clicks on 'From' dropdown
    And User selects 'New Delhi' from the dropdown
    And User clicks on 'To' dropdown
    And User selects 'Mumbai Central' from the dropdown
    And User selects date '2 October 2024' from date picker
    And User clicks on search button
    Then User should be redirected to the search results page
    When User double clicks on 'Duration' column header
    Then Results should be sorted by travel time in ascending order
    And User should be redirected to the sorted results page