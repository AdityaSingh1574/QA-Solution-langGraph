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
        implementation.enterUserId(userId);
    }

    @And("User types password {string}")
    public void userTypesPassword(String password) {
        implementation.enterPassword(password);
    }

    @And("User clicks login button")
    public void userClicksLoginButton() {
        implementation.clickLoginButton();
    }

    @Given("User navigates to manage policy")
    public void userNavigatesToManagePolicy() {
        implementation.navigateToManagePolicy();
    }

    @And("User is redirected to the MIS homepage")
    public void userIsRedirectedToMISHomepage() {
        implementation.verifyMISHomepage();
    }

    @When("User clicks on view policy")
    public void userClicksOnViewPolicy() {
        implementation.clickViewPolicy();
    }

    @And("User clicks on deactivate policy")
    public void userClicksOnDeactivatePolicy() {
        implementation.clickDeactivatePolicy();
    }

    @And("User clicks confirm yes")
    public void userClicksConfirmYes() {
        implementation.clickConfirmYes();
    }

    @And("User clicks on delete policy")
    public void userClicksOnDeletePolicy() {
        implementation.clickDeletePolicy();
    }

    @Then("User is redirected to the Manage Policy page")
    public void userIsRedirectedToManagePolicyPage() {
        implementation.verifyManagePolicyPage();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}