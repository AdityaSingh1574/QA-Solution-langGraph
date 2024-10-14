package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the login page")
    public void userIsOnLoginPage() {
        implementation.launchUrl();
    }

    @When("User enters email {string} in the email input field")
    public void userEntersEmail(String email) {
        implementation.enterEmail(email);
    }

    @And("User enters password {string} in the password input field")
    public void userEntersPassword(String password) {
        implementation.enterPassword(password);
    }

    @And("User clicks the 'sign in' button")
    public void userClicksSignInButton() {
        implementation.clickSignInButton();
    }

    @Then("User should be redirected to the dashboard")
    public void userRedirectedToDashboard() {
        implementation.verifyDashboardRedirect();
    }

    @Given("User selects 'Manage Courses' from the sidebar")
    public void userSelectsManageCourses() {
        implementation.selectManageCourses();
    }

    @And("User selects 'Batches' from the sidebar")
    public void userSelectsBatches() {
        implementation.selectBatches();
    }

    @Then("User should be redirected to the batches page")
    public void userRedirectedToBatchesPage() {
        implementation.verifyBatchesPageRedirect();
    }

    @When("User clicks the actions icon for the 'dummy' record")
    public void userClicksActionsIcon() {
        implementation.clickActionsIcon();
    }

    @And("User selects 'Assign Learners' from the actions dropdown")
    public void userSelectsAssignLearners() {
        implementation.selectAssignLearners();
    }

    @Then("User should be redirected to the assign learners page")
    public void userRedirectedToAssignLearnersPage() {
        implementation.verifyAssignLearnersPageRedirect();
    }

    @When("User gets the current assigned learners count")
    public void userGetsCurrentAssignedLearnersCount() {
        implementation.getCurrentAssignedLearnersCount();
    }

    @And("User unassigns the learner with email {string}")
    public void userUnassignsLearner(String email) {
        implementation.unassignLearner(email);
    }

    @And("User clicks the 'unassign selected' button")
    public void userClicksUnassignSelectedButton() {
        implementation.clickUnassignSelectedButton();
    }

    @And("User clicks the 'Yes' button to confirm unassignment")
    public void userConfirmsUnassignment() {
        implementation.confirmUnassignment();
    }

    @Then("User should validate the new assigned learners count is less than the initial count")
    public void userValidatesNewAssignedLearnersCount() {
        implementation.validateNewAssignedLearnersCount();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}