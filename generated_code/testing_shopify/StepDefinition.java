package generated_code.testing_shopify;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("user is on the landing page of website {}")
    public void userIsOnLandingPage(String url) {
        implementation.launchUrl(url);
    }

    @When("User Clicks on the {} on the landing page")
    public void userClicksOnProduct(String productName) {
        implementation.clickOnProduct(productName);
    }

    @Then("User is redirected to product page")
    public void userIsRedirectedToProductPage() {
        implementation.verifyProductPage();
    }

    @When("User clicks on \"Add to Cart\" for the product selected")
    public void userClicksAddToCart() {
        implementation.clickAddToCart();
    }

    @And("User Clicks on the Cart icon on the page")
    public void userClicksCartIcon() {
        implementation.clickCartIcon();
    }

    @Then("User prints the name of the first item in the cart")
    public void userPrintsFirstItemName() {
        String itemName = implementation.getFirstItemNameInCart();
        System.out.println("First item in cart: " + itemName);
    }

    @And("The first item in the cart should be {string}")
    public void verifyFirstItemInCart(String expectedItemName) {
        implementation.verifyFirstItemInCart(expectedItemName);
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}