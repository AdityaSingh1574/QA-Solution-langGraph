package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the MIS login page {string}")
    public void userIsOnMISLoginPage(String url) {
        implementation.launchUrl(url);
    }

    @When("User enters user id {string}")
    public void userEntersUserId(String userId) {
        implementation.enterUserId(userId);
    }

    @And("User enters password {string}")
    public void userEntersPassword(String password) {
        implementation.enterPassword(password);
    }

    @And("User clicks on the login button")
    public void userClicksOnLoginButton() {
        implementation.clickLoginButton();
    }

    @Given("User navigates to manage task sub details under task management")
    public void userNavigatesToManageTaskSubDetails() {
        implementation.navigateToManageTaskSubDetails();
    }

    @And("User is redirected to the MIS homepage")
    public void userIsRedirectedToMISHomepage() {
        implementation.verifyMISHomepage();
    }

    @When("User clicks on add new task details")
    public void userClicksOnAddNewTaskDetails() {
        implementation.clickAddNewTaskDetails();
    }

    @And("User enters task name as {string}")
    public void userEntersTaskName(String taskName) {
        implementation.enterTaskName(taskName);
    }

    @And("User clicks on the add button")
    public void userClicksOnAddButton() {
        implementation.clickAddButton();
    }

    @Then("User should be redirected to the task sub detail page")
    public void userShouldBeRedirectedToTaskSubDetailPage() {
        implementation.verifyTaskSubDetailPage();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}