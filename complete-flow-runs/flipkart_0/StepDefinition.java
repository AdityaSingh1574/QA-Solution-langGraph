package stepdefinitions;

import implementations.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the Flipkart homepage {string}")
    public void userIsOnFlipkartHomepage(String url) {
        implementation.launchUrl(url);
    }

    @When("User enters {string} in the search bar")
    public void userEntersInSearchBar(String searchTerm) {
        implementation.enterSearchTerm(searchTerm);
    }

    @When("User clicks on the search button")
    public void userClicksOnSearchButton() {
        implementation.clickSearchButton();
    }

    @Then("User should be redirected to the search results page")
    public void userShouldBeRedirectedToSearchResultsPage() {
        Assert.assertTrue(implementation.getCurrentUrl().contains("search"));
    }

    @When("User selects the first chair from the search results")
    public void userSelectsFirstChair() {
        implementation.selectFirstChair();
    }

    @Then("User should be redirected to the product details page")
    public void userShouldBeRedirectedToProductDetailsPage() {
        Assert.assertTrue(implementation.getCurrentUrl().contains("product"));
    }

    @When("User clicks on the {string} button")
    public void userClicksOnButton(String buttonName) {
        if (buttonName.equals("Add to Cart")) {
            implementation.clickAddToCartButton();
        } else if (buttonName.equals("Place Order")) {
            implementation.clickPlaceOrderButton();
        }
    }

    @Then("User should be redirected to the cart page")
    public void userShouldBeRedirectedToCartPage() {
        Assert.assertTrue(implementation.getCurrentUrl().contains("cart"));
    }

    @Then("User should be redirected to the order placement page")
    public void userShouldBeRedirectedToOrderPlacementPage() {
        Assert.assertTrue(implementation.getCurrentUrl().contains("order"));
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}