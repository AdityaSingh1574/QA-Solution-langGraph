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

    @Given("User selects {string} from the sidebar")
    public void userSelectsFromSidebar(String option) {
        implementation.selectFromSidebar(option);
    }

    @Then("User should be redirected to the user dashboard page")
    public void userShouldBeRedirectedToDashboard() {
        implementation.verifyDashboardRedirect();
    }

    @When("User clicks the actions icon for the {string} record")
    public void userClicksActionsIcon(String record) {
        implementation.clickActionsIcon(record);
    }

    @And("User selects {string} from the actions dropdown")
    public void userSelectsFromActionsDropdown(String option) {
        implementation.selectFromActionsDropdown(option);
    }

    @Then("User should be redirected to the assign learners page")
    public void userShouldBeRedirectedToAssignLearnersPage() {
        implementation.verifyAssignLearnersPageRedirect();
    }

    @When("User expands the {string} dropdown")
    public void userExpandsDropdown(String dropdown) {
        implementation.expandDropdown(dropdown);
    }

    @And("User selects {string} from the Category dropdown")
    public void userSelectsFromCategoryDropdown(String option) {
        implementation.selectFromCategoryDropdown(option);
    }

    @And("User selects {string} from the selected category dropdown")
    public void userSelectsFromSelectedCategoryDropdown(String option) {
        implementation.selectFromSelectedCategoryDropdown(option);
    }

    @Then("User gets the assigned learners count")
    public void userGetsAssignedLearnersCount() {
        implementation.getAssignedLearnersCount();
    }

    @When("User unassigns a learner from the filtered list")
    public void userUnassignsLearner() {
        implementation.unassignLearner();
    }

    @Then("User validates the count after unassigning")
    public void userValidatesCountAfterUnassigning() {
        implementation.validateCountAfterUnassigning();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}