package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("user is on the MIS homepage")
    public void userIsOnMISHomepage() {
        implementation.launchUrl();
    }

    @When("user navigates to {string} and then {string}")
    public void userNavigatesToSection(String mainSection, String subSection) {
        implementation.navigateToSection(mainSection, subSection);
    }

    @When("user selects {string} from the number of entries dropdown")
    public void userSelectsEntriesFromDropdown(String entries) {
        implementation.selectEntriesFromDropdown(entries);
    }

    @Then("the number of entries displayed should change to {int}")
    public void verifyNumberOfEntriesDisplayed(int expectedEntries) {
        implementation.verifyNumberOfEntriesDisplayed(expectedEntries);
    }

    @When("user clicks on the {string} button")
    public void userClicksOnButton(String buttonName) {
        implementation.clickOnButton(buttonName);
    }

    @Then("the next page of records should be displayed")
    public void verifyNextPageDisplayed() {
        implementation.verifyNextPageDisplayed();
    }

    @Then("the previous page of records should be displayed")
    public void verifyPreviousPageDisplayed() {
        implementation.verifyPreviousPageDisplayed();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}