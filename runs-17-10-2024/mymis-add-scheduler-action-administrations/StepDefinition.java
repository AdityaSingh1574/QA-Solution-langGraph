package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the login page {string}")
    public void userIsOnLoginPage(String url) {
        implementation.launchUrl(url);
    }

    @When("User enters user id {string} in the username field")
    public void userEntersUsername(String username) {
        implementation.enterUsername(username);
    }

    @And("User enters password {string} in the password field")
    public void userEntersPassword(String password) {
        implementation.enterPassword(password);
    }

    @And("User clicks on the login button")
    public void userClicksLoginButton() {
        implementation.clickLoginButton();
    }

    @Then("User should be redirected to the MyMIS homepage")
    public void userIsRedirectedToHomepage() {
        implementation.verifyHomepageRedirect();
    }

    @Given("User navigates to Manage Scheduler under Administrations")
    public void userNavigatesToManageScheduler() {
        implementation.navigateToManageScheduler();
    }

    @Then("User should be redirected to the Manage Scheduler page")
    public void userIsRedirectedToManageSchedulerPage() {
        implementation.verifyManageSchedulerPage();
    }

    @When("User clicks on the Add Scheduler Action button")
    public void userClicksAddSchedulerActionButton() {
        implementation.clickAddSchedulerActionButton();
    }

    @And("User enters scheduler name in the input field")
    public void userEntersSchedulerName() {
        implementation.enterSchedulerName("Test Scheduler");
    }

    @And("User enters description in the input field")
    public void userEntersDescription() {
        implementation.enterDescription("Test Description");
    }

    @And("User enters function name in the input field")
    public void userEntersFunctionName() {
        implementation.enterFunctionName("TestFunction");
    }

    @And("User clicks on the final Add button")
    public void userClicksFinalAddButton() {
        implementation.clickFinalAddButton();
    }

    @Then("User should be redirected to the Manage Scheduler page")
    public void userIsRedirectedBackToManageSchedulerPage() {
        implementation.verifyManageSchedulerPage();
    }
}