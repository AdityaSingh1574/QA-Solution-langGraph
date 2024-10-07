Feature: Search and Add Item to Cart on Walmart
  As a user, I want to search for a bag on Walmart and add it to my cart

Scenario: Search for a bag and add it to cart
  Given User is on the Walmart homepage "https://www.walmart.com/"
  When User enters "bag" in the search bar
  And User clicks on the search button
  Then User should be redirected to the search results page
  When User selects the first bag from the search results
  Then User should be redirected to the product page
  When User clicks on the "Add to Cart" button
  Then User should be redirected to the cart confirmation page
  When User clicks on the "View Cart" button
  Then User should be redirected to the cart page