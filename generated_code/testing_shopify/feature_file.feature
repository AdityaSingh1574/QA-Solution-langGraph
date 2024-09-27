Feature: Add to Cart on https://sauce-demo.myshopify.com/
As a user, I want to add items to my cart on the Sauce Demo Shopify website

Scenario: Add Noir jacket to Cart
    Given user is on the landing page of website https://sauce-demo.myshopify.com/
    When User Clicks on the Noir jacket on the landing page
    Then User is redirected to product page
    When User clicks on "Add to Cart" for the product selected
    And User Clicks on the Cart icon on the page
    Then User prints the name of the first item in the cart
    And The first item in the cart should be "Noir jacket"

Scenario: Add Grey jacket to Cart
    Given user is on the landing page of website https://sauce-demo.myshopify.com/
    When User Clicks on the Grey jacket on the landing page
    Then User is redirected to product page
    When User clicks on "Add to Cart" for the product selected
    And User Clicks on the Cart icon on the page
    Then User prints the name of the first item in the cart
    And The first item in the cart should be "Grey jacket"