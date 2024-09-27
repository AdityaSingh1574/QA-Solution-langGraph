package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinition {
    public Implementation implementation = new Implementation();

    @Given("user is on TestControl screen")
    public void userIsOnTestControlScreen() {
        implementation.launchUrl();
    }

    @When("click on Name section")
    public void clickOnNameSection() {
        implementation.clickOnNameSection();
    }

    @Then("verify if section is getting sorted in increasing form by printing first 3 Names")
    public void verifyIfSectionIsSortedAndPrintNames() {
        implementation.verifySortingAndPrintNames();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}