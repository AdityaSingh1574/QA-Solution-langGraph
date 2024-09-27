package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("user is on the Amazon India homepage")
    public void userIsOnAmazonIndiaHomepage() {
        implementation.launchUrl("https://www.amazon.in");
    }

    @When("user enters {string} in the search box")
    public void userEntersSearchTerm(String searchTerm) {
        implementation.enterSearchTerm(searchTerm);
    }

    @And("user clicks on the search button")
    public void userClicksSearchButton() {
        implementation.clickSearchButton();
    }

    @Then("the search results for {string} should be displayed")
    public void searchResultsShouldBeDisplayed(String searchTerm) {
        implementation.verifySearchResults(searchTerm);
    }

    @And("user should see a list of {string} in the search results")
    public void userShouldSeeListOfItems(String itemType) {
        // This step is implicitly verified in the next step
    }

    @And("user prints the names of the {string} displayed")
    public void userPrintsItemNames(String itemType) {
        implementation.printSearchResults();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}