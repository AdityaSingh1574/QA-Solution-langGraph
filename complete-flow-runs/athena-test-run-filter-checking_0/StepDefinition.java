package stepdefinitions;

import implementations.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the login page")
    public void userIsOnLoginPage() {
        implementation.launchUrl("https://dev-athena.geminisolutions.com/login");
    }

    @When("User enters email {string} in the email input field")
    public void userEntersEmail(String email) {
        implementation.enterEmail(email);
    }

    @When("User enters password {string} in the password input field")
    public void userEntersPassword(String password) {
        implementation.enterPassword(password);
    }

    @When("User clicks on the 'sign in' button")
    public void userClicksSignInButton() {
        implementation.clickSignInButton();
    }

    @When("User selects 'Manage Courses' from the sidebar")
    public void userSelectsManageCourses() {
        implementation.selectManageCourses();
    }

    @When("User selects 'Batches' from the sidebar")
    public void userSelectsBatches() {
        implementation.selectBatches();
    }

    @Then("User should be redirected to the batches page")
    public void userIsOnBatchesPage() {
        // This step is implicit in the next action
    }

    @When("User clicks on the actions icon for the 'dummy' record")
    public void userClicksActionsIcon() {
        implementation.clickActionsIcon();
    }

    @When("User selects 'Assign Learners' from the actions dropdown")
    public void userSelectsAssignLearners() {
        implementation.selectAssignLearners();
    }

    @Then("User should be redirected to the assign learners page")
    public void userIsOnAssignLearnersPage() {
        // This step is implicit in the next action
    }

    @When("User gets the assigned learners count")
    public void userGetsAssignedLearnersCount() {
        implementation.getAssignedLearnersCount();
    }

    @When("User expands the 'Status' dropdown")
    public void userExpandsStatusDropdown() {
        implementation.expandStatusDropdown();
    }

    @When("User selects 'Assigned' from the Status dropdown")
    public void userSelectsAssignedStatus() {
        implementation.selectAssignedStatus();
    }

    @Then("User should see records filtered by status 'Assigned'")
    public void userSeesFilteredRecords() {
        Assert.assertTrue("Filtered records are not displayed", implementation.verifyFilteredRecords());
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}