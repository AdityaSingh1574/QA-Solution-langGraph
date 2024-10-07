Feature: Hotel Booking on Booking.com
  As a user, I want to search for and book a hotel in New Delhi

  Scenario: Search for a hotel in New Delhi and view availability
    Given User is on the Booking.com homepage
    When User enters 'New Delhi' into the destination search field
    And User selects check-in date '2024-10-01'
    And User selects check-out date '2024-10-02'
    And User clicks the search button
    Then User should be redirected to the search results page
    When User views the list of available hotels
    And User selects the top result hotel
    And User clicks the 'see availability' button
    Then User should be redirected to the hotel's availability page