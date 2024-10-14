package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the login page")
    public void userIsOnLoginPage() {
        implementation.launchUrl("https://dev-athena.geminisolutions.com");
    }

    @When("User types {string} in the email field")
    public void userTypesEmail(String email) {
        implementation.enterEmail(email);
    }

    @When("User types {string} in the password field")
    public void userTypesPassword(String password) {
        implementation.enterPassword(password);
    }

    @When("User clicks the sign in button")
    public void userClicksSignIn() {
        implementation.clickSignIn();
    }

    @Given("User is on the user dashboard")
    public void userIsOnDashboard() {
        // This step is implicit after login, no action needed
    }

    @When("User selects {string} from the sidebar")
    public void userSelectsFromSidebar(String option) {
        implementation.selectSidebarOption(option);
    }

    @Then("User should be redirected to the batches page")
    public void userOnBatchesPage() {
        implementation.verifyBatchesPage();
    }

    @When("User clicks the actions icon for the {string} record")
    public void userClicksActionsIcon(String record) {
        implementation.clickActionsIcon(record);
    }

    @When("User selects {string} from the actions dropdown")
    public void userSelectsFromDropdown(String option) {
        implementation.selectDropdownOption(option);
    }

    @Then("User should be redirected to the assign learners page")
    public void userOnAssignLearnersPage() {
        implementation.verifyAssignLearnersPage();
    }

    @When("User gets the current assigned learners count")
    public void userGetsLearnerCount() {
        implementation.getLearnerCount();
    }

    @When("User unassigns the learner with email {string}")
    public void userUnassignsLearner(String email) {
        implementation.unassignLearner(email);
    }

    @When("User clicks the {string} button")
    public void userClicksButton(String buttonText) {
        implementation.clickButton(buttonText);
    }

    @When("User confirms by clicking the {string} button")
    public void userConfirms(String buttonText) {
        implementation.confirmAction(buttonText);
    }

    @Then("User should validate the count after unassigning")
    public void userValidatesCount() {
        implementation.validateUpdatedCount();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}