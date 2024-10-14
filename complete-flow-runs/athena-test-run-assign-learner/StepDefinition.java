package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the login page")
    public void userIsOnLoginPage() {
        implementation.launchUrl();
    }

    @When("User types {string} in the email field")
    public void userTypesEmail(String email) {
        implementation.enterEmail(email);
    }

    @When("User types {string} in the password field")
    public void userTypesPassword(String password) {
        implementation.enterPassword(password);
    }

    @When("User clicks the 'sign in' button")
    public void userClicksSignInButton() {
        implementation.clickSignInButton();
    }

    @Given("User is redirected to the user dashboard")
    public void userIsRedirectedToDashboard() {
        implementation.verifyDashboardRedirect();
    }

    @When("User selects 'Manage Courses' from the sidebar")
    public void userSelectsManageCourses() {
        implementation.selectManageCourses();
    }

    @When("User selects 'Batches' from the sidebar")
    public void userSelectsBatches() {
        implementation.selectBatches();
    }

    @Then("User is redirected to the batches page")
    public void userIsRedirectedToBatchesPage() {
        implementation.verifyBatchesPageRedirect();
    }

    @When("User clicks the actions icon for the 'dummy' record")
    public void userClicksActionsIcon() {
        implementation.clickActionsIcon();
    }

    @When("User selects 'Assign Learners' from the actions dropdown")
    public void userSelectsAssignLearners() {
        implementation.selectAssignLearners();
    }

    @Then("User is redirected to the assign learners page")
    public void userIsRedirectedToAssignLearnersPage() {
        implementation.verifyAssignLearnersPageRedirect();
    }

    @When("User gets the current assigned learners count")
    public void userGetsCurrentAssignedLearnersCount() {
        implementation.getCurrentAssignedLearnersCount();
    }

    @When("User assigns a learner with email {string}")
    public void userAssignsLearner(String email) {
        implementation.assignLearner(email);
    }

    @When("User clicks the 'assign selected' button")
    public void userClicksAssignSelectedButton() {
        implementation.clickAssignSelectedButton();
    }

    @When("User confirms assignment by clicking the 'Yes' button")
    public void userConfirmsAssignment() {
        implementation.confirmAssignment();
    }

    @Then("User validates the count after assigning")
    public void userValidatesCountAfterAssigning() {
        implementation.validateCountAfterAssigning();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}