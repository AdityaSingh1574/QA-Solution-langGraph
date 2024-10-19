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

    @When("User enters email {string} in the email field")
    public void userEntersEmail(String email) {
        implementation.enterEmail(email);
    }

    @And("User enters password {string} in the password field")
    public void userEntersPassword(String password) {
        implementation.enterPassword(password);
    }

    @And("User clicks the 'sign in' button")
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
        implementation.verifyAssignLearnersPage();
    }

    @When("User gets the assigned learners count")
    public void userGetsAssignedLearnersCount() {
        implementation.getAssignedLearnersCount();
    }

    @And("User expands the 'Status' dropdown")
    public void userExpandsStatusDropdown() {
        implementation.expandStatusDropdown();
    }

    @And("User selects 'Assigned' from the dropdown")
    public void userSelectsAssignedStatus() {
        implementation.selectAssignedStatus();
    }

    @Then("User should see records filtered by status 'Assigned'")
    public void userSeesFilteredRecords() {
        implementation.verifyFilteredRecords();
    }
}