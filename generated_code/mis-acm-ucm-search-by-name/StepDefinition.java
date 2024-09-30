package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("the user is logged into the MIS system")
    public void userIsLoggedIntoMIS() {
        implementation.launchUrl();
        implementation.login();
    }

    @When("user navigates to {string} and then {string}")
    public void userNavigatesToMenus(String menu1, String menu2) {
        implementation.navigateToMenu(menu1, menu2);
    }

    @And("user enters {string} in the search bar")
    public void userEntersInSearchBar(String searchTerm) {
        implementation.enterSearchTerm(searchTerm);
    }

    @Then("the system should display search results")
    public void systemDisplaysSearchResults() {
        implementation.verifySearchResultsDisplayed();
    }

    @And("the first result's name field should contain {string}")
    public void firstResultContainsName(String expectedName) {
        implementation.verifyFirstResultName(expectedName);
    }

    @And("user verifies that the search function is working correctly for {string}")
    public void verifySearchFunctionWorking(String searchTerm) {
        implementation.verifySearchFunctionality(searchTerm);
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}