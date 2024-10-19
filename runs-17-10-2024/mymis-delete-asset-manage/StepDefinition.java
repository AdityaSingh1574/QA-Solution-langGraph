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
        implementation.launchUrl("https://mymis.geminisolutions.com");
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

    @Given("User navigates to manage under asset allocation")
    public void userNavigatesToManageAssetAllocation() {
        implementation.navigateToManageAssetAllocation();
    }

    @And("User is redirected to the asset management page")
    public void userIsRedirectedToAssetManagementPage() {
        implementation.verifyAssetManagementPage();
    }

    @When("User clicks on delete asset button")
    public void userClicksOnDeleteAssetButton() {
        implementation.clickDeleteAssetButton();
    }

    @And("User clicks yes button to confirm")
    public void userClicksYesButtonToConfirm() {
        implementation.confirmDeleteAsset();
    }

    @Then("User should be redirected to the asset management page")
    public void userShouldBeRedirectedToAssetManagementPage() {
        implementation.verifyAssetManagementPage();
        implementation.closeBrowser();
    }
}