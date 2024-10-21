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

    @When("User types user id {string}")
    public void userTypesUserId(String userId) {
        implementation.enterUsername(userId);
    }

    @And("User types password {string}")
    public void userTypesPassword(String password) {
        implementation.enterPassword(password);
    }

    @And("User clicks login button")
    public void userClicksLoginButton() {
        implementation.clickLoginButton();
    }

    @Then("User should be redirected to the dashboard")
    public void userShouldBeRedirectedToDashboard() {
        implementation.verifyDashboardRedirection();
    }

    @Given("User navigates to Manage designation under HR Portal")
    public void userNavigatesToManageDesignation() {
        implementation.navigateToManageDesignation();
    }

    @And("User is redirected to the Manage Designation page")
    public void userIsRedirectedToManageDesignationPage() {
        implementation.verifyManageDesignationPage();
    }

    @When("User clicks 'Add' button")
    public void userClicksAddButton() {
        implementation.clickAddButton();
    }

    @And("User enters designation group title as {string} in input field")
    public void userEntersDesignationGroupTitle(String title) {
        implementation.enterDesignationGroupTitle(title);
    }

    @And("User clicks save button")
    public void userClicksSaveButton() {
        implementation.clickSaveButton();
    }

    @Then("The new designation group should be added successfully")
    public void newDesignationGroupShouldBeAdded() {
        implementation.verifyNewDesignationGroupAdded();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}