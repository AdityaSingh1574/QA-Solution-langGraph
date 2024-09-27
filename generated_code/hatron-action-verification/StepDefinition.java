package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("user is on TestControl screen")
    public void userIsOnTestControlScreen() {
        implementation.launchUrl("https://testcontrol.example.com"); // Replace with actual URL
    }

    @When("click on Actions")
    public void clickOnActions() {
        implementation.clickOnActions();
    }

    @Then("verify if {string} exists in action menu by clicking it")
    public void verifyIfActionExistsInActionMenu(String action) {
        boolean exists = implementation.verifyActionExists(action);
        Assert.assertTrue("The action '" + action + "' does not exist in the action menu", exists);
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}