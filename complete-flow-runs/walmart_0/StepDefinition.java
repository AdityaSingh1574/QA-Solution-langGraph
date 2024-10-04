package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the Walmart homepage {string}")
    public void userIsOnWalmartHomepage(String url) {
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
        implementation.verifySearchResultsPage();
    }

    @When("User selects the first bag from the search results")
    public void userSelectsFirstBag() {
        implementation.selectFirstBag();
    }

    @Then("User should be redirected to the product page")
    public void userShouldBeRedirectedToProductPage() {
        implementation.verifyProductPage();
    }

    @When("User clicks on the {string} button")
    public void userClicksOnButton(String buttonName) {
        if (buttonName.equals("Add to Cart")) {
            implementation.clickAddToCartButton();
        } else if (buttonName.equals("View Cart")) {
            implementation.clickViewCartButton();
        }
    }

    @Then("User should be redirected to the cart confirmation page")
    public void userShouldBeRedirectedToCartConfirmationPage() {
        implementation.verifyCartConfirmationPage();
    }

    @Then("User should be redirected to the cart page")
    public void userShouldBeRedirectedToCartPage() {
        implementation.verifyCartPage();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}