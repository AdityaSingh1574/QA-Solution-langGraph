package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the login page of https://dev-athena.geminisolutions.com/login")
    public void userIsOnLoginPage() {
        implementation.launchUrl("https://dev-athena.geminisolutions.com/login");
    }

    @When("User enters email {string} in the email field")
    public void userEntersEmail(String email) {
        implementation.enterEmail(email);
    }

    @And("User enters password {string} in the password field")
    public void userEntersPassword(String password) {
        implementation.enterPassword(password);
    }

    @And("User clicks the sign in button")
    public void userClicksSignInButton() {
        implementation.clickSignInButton();
    }

    @Then("User should be redirected to the user dashboard")
    public void userIsRedirectedToDashboard() {
        implementation.verifyDashboardRedirection();
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
    public void userIsRedirectedToBatchesPage() {
        implementation.verifyBatchesPageRedirection();
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
    public void userIsRedirectedToAssignLearnersPage() {
        implementation.verifyAssignLearnersPageRedirection();
    }

    @When("User gets the assigned learners count")
    public void userGetsAssignedLearnersCount() {
        implementation.getAssignedLearnersCount();
    }

    @And("User selects an unassigned learner from the current page")
    public void userSelectsUnassignedLearner() {
        implementation.selectUnassignedLearner();
    }

    @And("User navigates to the next page")
    public void userNavigatesToNextPage() {
        implementation.navigateToNextPage();
    }

    @And("User selects another unassigned learner")
    public void userSelectsAnotherUnassignedLearner() {
        implementation.selectUnassignedLearner();
    }

    @And("User clicks the 'Assign Selected' button")
    public void userClicksAssignSelectedButton() {
        implementation.clickAssignSelectedButton();
    }

    @And("User clicks the 'Yes' button to confirm assignment")
    public void userConfirmsAssignment() {
        implementation.confirmAssignment();
    }

    @Then("User should be redirected to the batches page")
    public void userIsRedirectedBackToBatchesPage() {
        implementation.verifyBatchesPageRedirection();
    }
}