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

    @Given("User navigates to manage assets under Asset Allocation")
    public void userNavigatesToManageAssets() {
        implementation.navigateToManageAssets();
    }

    @And("User is redirected to the MIS homepage")
    public void userIsRedirectedToHomepage() {
        implementation.verifyHomepageRedirect();
    }

    @When("User clicks on Add new asset type button")
    public void userClicksAddNewAssetTypeButton() {
        implementation.clickAddNewAssetTypeButton();
    }

    @And("User enters asset type as {string}")
    public void userEntersAssetType(String assetType) {
        implementation.enterAssetType(assetType);
    }

    @And("User selects {string} for Is temporary option from dropdown")
    public void userSelectsIsTemporaryOption(String option) {
        implementation.selectIsTemporaryOption(option);
    }

    @And("User clicks add button")
    public void userClicksAddButton() {
        implementation.clickAddButton();
    }

    @Then("User should be redirected to the Asset Management page")
    public void userIsRedirectedToAssetManagementPage() {
        implementation.verifyAssetManagementPageRedirect();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}