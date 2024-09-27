package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("user is on TestControl screen at {}")
    public void userIsOnTestControlScreen(String url) {
        implementation.launchUrl(url);
    }

    @When("click on Actions")
    public void clickOnActions() {
        implementation.clickOnActions();
    }

    @Then("verify if {string} exists in action menu by clicking on it")
    public void verifyIfItemExistsInActionMenu(String menuItem) {
        assert implementation.verifyActionMenuItemExists(menuItem) : menuItem + " does not exist in the action menu";
        implementation.clickOnMenuItem(menuItem);
    }

    @And("verify if user is navigated to {string}")
    public void verifyIfUserIsNavigatedTo(String destination) {
        assert implementation.verifyNavigation(destination) : "Navigation to " + destination + " failed";
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}