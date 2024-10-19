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

    @When("User enters email {string} and password {string}")
    public void userEntersCredentials(String email, String password) {
        implementation.enterCredentials(email, password);
    }

    @And("User clicks on 'sign in' button")
    public void userClicksSignInButton() {
        implementation.clickSignInButton();
    }

    @Given("User selects 'Manage Courses' from the sidebar")
    public void userSelectsManageCourses() {
        implementation.selectManageCourses();
    }

    @And("User selects 'Batches' from the sidebar")
    public void userSelectsBatches() {
        implementation.selectBatches();
    }

    @Then("User should be redirected to the user dashboard page")
    public void userIsRedirectedToDashboard() {
        implementation.verifyDashboardRedirection();
    }

    @When("User clicks on the actions icon for the 'dummy' record")
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

    @When("User gets the current assigned learners count")
    public void userGetsCurrentAssignedLearnersCount() {
        implementation.getCurrentAssignedLearnersCount();
    }

    @And("User assigns a learner with email {string}")
    public void userAssignsLearner(String email) {
        implementation.assignLearner(email);
    }

    @And("User clicks on 'assign selected' button")
    public void userClicksAssignSelectedButton() {
        implementation.clickAssignSelectedButton();
    }

    @And("User confirms assignment by clicking 'Yes' button")
    public void userConfirmsAssignment() {
        implementation.confirmAssignment();
    }

    @Then("User should validate the count after assigning")
    public void userValidatesCountAfterAssigning() {
        implementation.validateCountAfterAssigning();
    }
}