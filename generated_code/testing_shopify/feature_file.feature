Feature: Complete Shopping Journey on https://sauce-demo.myshopify.com/
  As a user
  I want to select a product, add it to my cart, and review the cart
  So that I can complete a purchase

  Scenario: Complete shopping journey with Noir Jacket
    Given the user is on the landing page of https://sauce-demo.myshopify.com/
    When the user clicks on "Noir Jacket" on the landing page
    Then the user is redirected to the product page for "Noir Jacket"
    When the user clicks the "Add to Cart" button on the product page
    Then the item is added to the user's cart
    And the cart updates are reflected in real-time
    When the user clicks on the "Cart" icon
    Then the user is navigated to the cart summary page
    And the first item in the cart is displayed prominently
    And the cart contents match the items added by the user

  Scenario: Complete shopping journey with Grey Jacket
    Given the user is on the landing page of https://sauce-demo.myshopify.com/
    When the user clicks on "Grey Jacket" on the landing page
    Then the user is redirected to the product page for "Grey Jacket"
    When the user clicks the "Add to Cart" button on the product page
    Then the item is added to the user's cart
    And the cart updates are reflected in real-time
    When the user clicks on the "Cart" icon
    Then the user is navigated to the cart summary page
    And the first item in the cart is displayed prominently
    And the cart contents match the items added by the user