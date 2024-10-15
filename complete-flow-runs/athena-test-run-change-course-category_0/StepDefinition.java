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

    @And("User clicks on the 'sign in' button")
    public void userClicksSignInButton() {
        implementation.clickSignInButton();
    }

    @Then("User should be logged in successfully")
    public void userShouldBeLoggedIn() {
        implementation.verifyLogin();
    }

    @Given("User is on the dashboard page")
    public void userIsOnDashboardPage() {
        implementation.verifyDashboard();
    }

    @When("User selects 'Manage Courses' from the sidebar")
    public void userSelectsManageCourses() {
        implementation.selectManageCourses();
    }

    @And("User selects 'Batches' from the sidebar")
    public void userSelectsBatches() {
        implementation.selectBatches();
    }

    @And("User clicks on the actions icon for the 'dummy' record")
    public void userClicksActionsIcon() {
        implementation.clickActionsIcon();
    }

    @And("User selects 'Assign Learners' from the actions dropdown")
    public void userSelectsAssignLearners() {
        implementation.selectAssignLearners();
    }

    @Then("User should be redirected to the assign learners page")
    public void userRedirectedToAssignLearnersPage() {
        implementation.verifyAssignLearnersPage();
    }

    @When("User expands the 'Category' dropdown")
    public void userExpandsCategoryDropdown() {
        implementation.expandCategoryDropdown();
    }

    @And("User selects 'EC' from the Category dropdown")
    public void userSelectsEC() {
        implementation.selectEC();
    }

    @And("User expands the 'selected category' dropdown")
    public void userExpandsSelectedCategoryDropdown() {
        implementation.expandSelectedCategoryDropdown();
    }

    @And("User selects 'QA' from the selected category dropdown")
    public void userSelectsQA() {
        implementation.selectQA();
    }

    @Then("User should see records filtered by category 'EC' and subcategory 'QA'")
    public void userSeesFilteredRecords() {
        implementation.verifyFilteredRecords();
    }

    @And("User should see the assigned learners count")
    public void userSeesAssignedLearnersCount() {
        implementation.verifyAssignedLearnersCount();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}