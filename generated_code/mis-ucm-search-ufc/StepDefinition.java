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

    @When("user navigates on {string} and then {string}")
    public void userNavigatesTo(String mainMenu, String subMenu) {
        implementation.navigateToUserCardMapping(mainMenu, subMenu);
    }

    @And("searching a {string} card by typing the user in the search input")
    public void searchUserCard(String searchType) {
        implementation.searchUserCard(searchType);
    }

    @And("user Unfinalize Card Mapping by clicking on additional options and then clicking Unfinalize")
    public void unfinalizeCardMapping() {
        implementation.unfinalizeCardMapping();
    }

    @Then("Verify Mapping unfinalized")
    public void verifyMappingUnfinalized() {
        implementation.verifyMappingUnfinalized();
    }

    @And("the card status should change to 'Unfinalized'")
    public void verifyCardStatusUnfinalized() {
        implementation.verifyCardStatusUnfinalized();
    }

    @And("the card should be available for re-mapping")
    public void verifyCardAvailableForRemapping() {
        implementation.verifyCardAvailableForRemapping();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}