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

    @When("User types email {string}")
    public void userTypesEmail(String email) {
        implementation.enterEmail(email);
    }

    @When("User types password {string}")
    public void userTypesPassword(String password) {
        implementation.enterPassword(password);
    }

    @When("User clicks 'Sign In' button")
    public void userClicksSignInButton() {
        implementation.clickSignInButton();
    }

    @Given("User is on the user dashboard")
    public void userIsOnDashboard() {
        // This step is implicit after successful login
    }

    @When("User selects 'Manage Courses' from sidebar")
    public void userSelectsManageCourses() {
        implementation.clickManageCourses();
    }

    @When("User selects 'Batches' from sidebar")
    public void userSelectsBatches() {
        implementation.clickBatches();
    }

    @Then("User should be redirected to the batches page")
    public void userOnBatchesPage() {
        implementation.verifyBatchesPage();
    }

    @When("User clicks actions icon of record 'dummy'")
    public void userClicksActionsIcon() {
        implementation.clickActionsIcon();
    }

    @When("User selects 'Assign Learners' from actions dropdown")
    public void userSelectsAssignLearners() {
        implementation.selectAssignLearners();
    }

    @Then("User should be redirected to the assign learners page")
    public void userOnAssignLearnersPage() {
        implementation.verifyAssignLearnersPage();
    }

    @When("User gets the initial assigned learners count")
    public void userGetsInitialCount() {
        implementation.getInitialAssignedLearnersCount();
    }

    @When("User selects an unassigned learner from current page")
    public void userSelectsUnassignedLearner() {
        implementation.selectUnassignedLearner();
    }

    @When("User goes to the next page")
    public void userGoesToNextPage() {
        implementation.goToNextPage();
    }

    @When("User clicks 'Assign Selected' button")
    public void userClicksAssignSelectedButton() {
        implementation.clickAssignSelectedButton();
    }

    @When("User confirms assignment by clicking 'Yes' button")
    public void userConfirmsAssignment() {
        implementation.confirmAssignment();
    }

    @Then("User should validate the count after assigning learners from multiple pages")
    public void userValidatesAssignedLearnersCount() {
        implementation.validateAssignedLearnersCount();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}