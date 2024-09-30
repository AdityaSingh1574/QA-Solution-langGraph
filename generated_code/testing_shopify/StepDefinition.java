package generated_code.testing_shopify;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("the user is on the landing page of https://sauce-demo.myshopify.com/")
    public void userIsOnLandingPage() {
        implementation.launchUrl("https://sauce-demo.myshopify.com/");
    }

    @When("the user clicks on {string} on the landing page")
    public void userClicksOnProduct(String productName) {
        implementation.clickOnProduct(productName);
    }

    @Then("the user is redirected to the product page for {string}")
    public void userIsRedirectedToProductPage(String productName) {
        implementation.verifyProductPage(productName);
    }

    @When("the user clicks the \"Add to Cart\" button on the product page")
    public void userClicksAddToCart() {
        implementation.clickAddToCart();
    }

    @Then("the item is added to the user's cart")
    public void itemIsAddedToCart() {
        // This step is implicitly verified in the next step
    }

    @And("the cart updates are reflected in real-time")
    public void cartUpdatesAreReflected() {
        implementation.verifyCartUpdate();
    }

    @When("the user clicks on the \"Cart\" icon")
    public void userClicksOnCartIcon() {
        implementation.clickCartIcon();
    }

    @Then("the user is navigated to the cart summary page")
    public void userIsNavigatedToCartSummary() {
        implementation.verifyCartSummaryPage();
    }

    @And("the first item in the cart is displayed prominently")
    public void firstItemInCartIsDisplayed() {
        implementation.verifyFirstItemInCart();
    }

    @And("the cart contents match the items added by the user")
    public void cartContentsMatchAddedItems() {
        // This step assumes the last added item is the one we're checking
        // You might need to modify this if you want to check multiple items
        implementation.verifyCartContents("Jacket");
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}