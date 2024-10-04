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

    @Then("User should be redirected to the homepage")
    public void userShouldBeRedirectedToHomepage() {
        implementation.verifyHomepage();
    }

    @Given("User navigates to manage policy page")
    public void userNavigatesToManagePolicyPage() {
        implementation.navigateToManagePolicyPage();
    }

    @When("User clicks on view policy")
    public void userClicksOnViewPolicy() {
        implementation.clickViewPolicy();
    }

    @And("User clicks on deactivate policy")
    public void userClicksOnDeactivatePolicy() {
        implementation.clickDeactivatePolicy();
    }

    @And("User confirms deactivation by clicking yes")
    public void userConfirmsDeactivation() {
        implementation.confirmDeactivation();
    }

    @And("User clicks on delete policy")
    public void userClicksOnDeletePolicy() {
        implementation.clickDeletePolicy();
    }

    @And("User confirms deletion by clicking yes")
    public void userConfirmsDeletion() {
        implementation.confirmDeletion();
    }

    @Then("User should be redirected to the manage policy page")
    public void userShouldBeRedirectedToManagePolicyPage() {
        implementation.verifyManagePolicyPage();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}