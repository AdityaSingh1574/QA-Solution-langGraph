Feature: Search and View Weather on AccuWeather
  As a user, I want to search for a location and view its current weather on AccuWeather

  Scenario: Search for New Delhi's weather on AccuWeather
    Given User is on the AccuWeather homepage "https://www.accuweather.com/"
    When User types "new delhi" into the location input field
    And User presses enter
    Then User should be redirected to the search results page
    When User views the search results
    And User selects the first option
    Then User should be redirected to the New Delhi weather page
    And User should see the current weather for New Delhi, India