package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    public Implementation implementation = new Implementation();

    @Given("user is on TestControl screen")
    public void userIsOnTestControlScreen() {
        implementation.launchUrl();
    }

    @When("user clicks on the first Test in the list")
    public void userClicksOnFirstTest() {
        implementation.clickFirstTest();
    }

    @Then("the test details screen should be displayed")
    public void verifyTestDetailsScreenDisplayed() {
        implementation.verifyTestDetailsScreen();
    }

    @And("the test URL should be printed in the console")
    public void printTestUrlInConsole() {
        implementation.printTestUrl();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}