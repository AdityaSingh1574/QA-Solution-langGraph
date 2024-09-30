package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    public Implementation implementation = new Implementation();

    @Given("Login to MIS with Username {string} and password {string}")
    public void loginToMIS(String username, String password) {
        implementation.launchUrl("https://mymis.geminisolutions.com/");
        implementation.enterCredentials(username, password);
    }

    @When("Click on Signin button")
    public void clickSigninButton() {
        implementation.clickSigninButton();
    }

    @Then("User should be navigated to MIS homepage")
    public void verifyMISHomepage() {
        implementation.verifyMISHomepage();
    }

    @When("user navigates on {string} and then {string}")
    public void navigateToManageAccessCard(String dropdown, String option) {
        implementation.navigateToManageAccessCard(dropdown, option);
    }

    @And("Verify Entries changes to {string} number of entries by selecting {string} records from record selection drop down")
    public void verifyEntriesChange(String expectedEntries, String selectedEntries) {
        implementation.verifyEntriesChange(expectedEntries, selectedEntries);
    }

    @And("Verify Next {string} Button works")
    public void verifyNextButtonWorks(String buttonText) {
        implementation.verifyNextButtonWorks(buttonText);
    }

    @And("Verify Previous {string} works")
    public void verifyPreviousButtonWorks(String buttonText) {
        implementation.verifyPreviousButtonWorks(buttonText);
    }

    @Then("the page should display {int} records")
    public void verifyRecordCount(int expectedCount) {
        implementation.verifyRecordCount(expectedCount);
    }

    @And("user should be able to navigate through pages using Next and Previous buttons")
    public void verifyPageNavigation() {
        implementation.verifyPageNavigation();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}