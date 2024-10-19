package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the MIS login page {string}")
    public void userIsOnMISLoginPage(String url) {
        implementation.launchUrl(url);
    }

    @When("User enters user id {string} in the username field")
    public void userEntersUsername(String username) {
        implementation.enterUsername(username);
    }

    @And("User enters password {string} in the password field")
    public void userEntersPassword(String password) {
        implementation.enterPassword(password);
    }

    @And("User clicks on the login button")
    public void userClicksLoginButton() {
        implementation.clickLoginButton();
    }

    @Given("User navigates to the Asset Allocation section")
    public void userNavigatesToAssetAllocation() {
        implementation.navigateToAssetAllocation();
    }

    @And("User selects Manage Assets option")
    public void userSelectsManageAssets() {
        implementation.selectManageAssets();
    }

    @Then("User should be redirected to the Manage Assets page")
    public void userIsRedirectedToManageAssetsPage() {
        implementation.verifyManageAssetsPage();
    }

    @When("User selects edit asset option")
    public void userSelectsEditAsset() {
        implementation.selectEditAsset();
    }

    @And("User changes asset type to {string}")
    public void userChangesAssetType(String assetType) {
        implementation.changeAssetType(assetType);
    }

    @And("User changes serial number to {string}")
    public void userChangesSerialNumber(String serialNumber) {
        implementation.changeSerialNumber(serialNumber);
    }

    @And("User clicks on update asset button")
    public void userClicksUpdateAssetButton() {
        implementation.clickUpdateAssetButton();
    }

    @Then("User should see the updated asset details")
    public void userSeesUpdatedAssetDetails() {
        implementation.verifyUpdatedAssetDetails();
    }
}