Feature: Search and Add Chair to Cart on Flipkart
  As a user, I want to search for a chair on Flipkart and add it to my cart

  Scenario: Search for Chair and Add to Cart
    Given User is on the Flipkart homepage "https://www.flipkart.com/"
    When User enters "chair" in the search bar
    And User clicks on the search button
    Then User should be redirected to the search results page
    When User selects the first chair from the search results
    Then User should be redirected to the product details page
    When User clicks on the "Add to Cart" button
    Then User should be redirected to the cart page
    When User clicks on the "Place Order" button
    Then User should be redirected to the order placement page