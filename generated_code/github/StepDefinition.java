package generated_code.github;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("user is on the landing page of the website {}")
    public void userIsOnLandingPage(String url) {
        implementation.launchUrl(url);
    }

    @When("user clicks on the search button")
    public void userClicksOnSearchButton() {
        implementation.clickSearchButton();
    }

    @And("user types {string} in the search bar")
    public void userTypesInSearchBar(String query) {
        implementation.enterSearchQuery(query);
    }

    @And("user clicks enter for searching")
    public void userClicksEnterForSearching() {
        implementation.pressEnterToSearch();
    }

    @Then("user is on the results page")
    public void userIsOnResultsPage() {
        implementation.verifyResultsPage();
    }

    @And("user prints the first 3 names of the results page")
    public void userPrintsFirstThreeNames() {
        implementation.printFirstThreeRepoNames();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}