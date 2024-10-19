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

    @When("User enters email {string}")
    public void userEntersEmail(String email) {
        implementation.enterEmail(email);
    }

    @When("User enters password {string}")
    public void userEntersPassword(String password) {
        implementation.enterPassword(password);
    }

    @When("User clicks on 'sign in' button")
    public void userClicksSignInButton() {
        implementation.clickSignInButton();
    }

    @Given("User is on the user dashboard")
    public void userIsOnDashboard() {
        // This step is implicit after successful login
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
    public void userOnBatchesPage() {
        implementation.verifyBatchesPage();
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
    public void userOnAssignLearnersPage() {
        implementation.verifyAssignLearnersPage();
    }

    @When("User gets the assigned learners count")
    public void userGetsAssignedLearnersCount() {
        implementation.getAssignedLearnersCount();
    }

    @When("User expands the 'Category' dropdown")
    public void userExpandsCategoryDropdown() {
        implementation.expandCategoryDropdown();
    }

    @When("User selects 'EC' from the Category dropdown")
    public void userSelectsEC() {
        implementation.selectECCategory();
    }

    @When("User expands the 'selected category' dropdown")
    public void userExpandsSelectedCategoryDropdown() {
        implementation.expandSelectedCategoryDropdown();
    }

    @When("User selects 'QA' from the selected category dropdown")
    public void userSelectsQA() {
        implementation.selectQASubcategory();
    }

    @Then("User should see records filtered by category 'EC' and subcategory 'QA'")
    public void userSeesFilteredRecords() {
        implementation.verifyFilteredRecords();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}