package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinition {
    public Implementation implementation = new Implementation();

    @Given("User is on the login page {string}")
    public void userIsOnLoginPage(String url) {
        implementation.launchUrl(url);
    }

    @When("User enters user id {string} in the username field")
    public void userEntersUsername(String username) {
        implementation.enterUsername(username);
    }

    @When("User enters password {string} in the password field")
    public void userEntersPassword(String password) {
        implementation.enterPassword(password);
    }

    @When("User clicks on the login button")
    public void userClicksLoginButton() {
        implementation.clickLoginButton();
    }

    @Then("User should be redirected to the MIS portal homepage")
    public void userIsRedirectedToHomepage() {
        implementation.verifyHomepage();
    }

    @Given("User navigates to the Manage Assets page under Asset Allocation")
    public void userNavigatesToManageAssetsPage() {
        implementation.navigateToManageAssetsPage();
    }

    @When("User clicks on the Add new asset type button")
    public void userClicksAddNewAssetTypeButton() {
        implementation.clickAddNewAssetTypeButton();
    }

    @When("User types {string} in the asset type field")
    public void userTypesAssetType(String assetType) {
        implementation.enterAssetType(assetType);
    }

    @When("User selects {string} for Is temporary option from the dropdown")
    public void userSelectsIsTemporaryOption(String option) {
        implementation.selectIsTemporaryOption(option);
    }

    @When("User clicks on the add button")
    public void userClicksAddButton() {
        implementation.clickAddButton();
    }

    @Then("User should be redirected to the Asset Management page")
    public void userIsRedirectedToAssetManagementPage() {
        implementation.verifyAssetManagementPage();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}