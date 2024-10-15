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

    @When("User enters user id {string}")
    public void userEntersUserId(String userId) {
        implementation.enterUserId(userId);
    }

    @And("User enters password {string}")
    public void userEntersPassword(String password) {
        implementation.enterPassword(password);
    }

    @And("User clicks on the login button")
    public void userClicksLoginButton() {
        implementation.clickLoginButton();
    }

    @Given("User navigates to manage assets under Asset Allocation")
    public void userNavigatesToManageAssets() {
        implementation.navigateToManageAssets();
    }

    @And("User is redirected to the asset management page")
    public void userIsRedirectedToAssetManagementPage() {
        implementation.verifyAssetManagementPage();
    }

    @When("User selects edit asset option")
    public void userSelectsEditAssetOption() {
        implementation.clickEditAssetButton();
    }

    @And("User changes asset type to CPU")
    public void userChangesAssetTypeToCPU() {
        implementation.changeAssetType("CPU");
    }

    @And("User changes serial number to SRN000089")
    public void userChangesSerialNumber() {
        implementation.changeSerialNumber("SRN000089");
    }

    @And("User clicks update asset button")
    public void userClicksUpdateAssetButton() {
        implementation.clickUpdateAssetButton();
    }

    @Then("User should be redirected to the asset management confirmation page")
    public void userIsRedirectedToConfirmationPage() {
        implementation.verifyConfirmationPage();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}