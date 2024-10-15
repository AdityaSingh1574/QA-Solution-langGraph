package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the login page")
    public void userIsOnLoginPage() {
        implementation.launchUrl("https://mymis.geminisolutions.com");
    }

    @When("User types user id {string}")
    public void userTypesUserId(String userId) {
        implementation.enterUsername(userId);
    }

    @When("User types password {string}")
    public void userTypesPassword(String password) {
        implementation.enterPassword(password);
    }

    @When("User clicks login button")
    public void userClicksLoginButton() {
        implementation.clickLoginButton();
    }

    @Given("User navigates to manage under asset allocation")
    public void userNavigatesToManageAssetAllocation() {
        implementation.navigateToManageAsset();
    }

    @When("User clicks on delete asset")
    public void userClicksOnDeleteAsset() {
        implementation.clickDeleteAsset();
    }

    @When("User clicks yes to confirm")
    public void userConfirmsDelete() {
        implementation.confirmDelete();
    }

    @Then("User should be redirected to the Asset Management page")
    public void userIsRedirectedToAssetManagementPage() {
        implementation.verifyRedirectionToAssetManagement();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}