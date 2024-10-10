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

    @Then("User should be redirected to the MIS portal homepage")
    public void userIsRedirectedToHomepage() {
        implementation.verifyHomepage();
    }

    @Given("User navigates to the Asset Allocation section")
    public void userNavigatesToAssetAllocation() {
        implementation.navigateToAssetAllocation();
    }

    @And("User clicks on Manage Assets")
    public void userClicksOnManageAssets() {
        implementation.clickManageAssets();
    }

    @Then("User should be redirected to the Asset Management page")
    public void userIsRedirectedToAssetManagementPage() {
        implementation.verifyAssetManagementPage();
    }

    @When("User clicks on the Add new asset type button")
    public void userClicksAddNewAssetTypeButton() {
        implementation.clickAddNewAssetTypeButton();
    }

    @And("User enters {string} as the asset type")
    public void userEntersAssetType(String assetType) {
        implementation.enterAssetType(assetType);
    }

    @And("User selects {string} for Is temporary option from the dropdown")
    public void userSelectsIsTemporaryOption(String option) {
        implementation.selectIsTemporaryOption(option);
    }

    @And("User clicks on the add button")
    public void userClicksAddButton() {
        implementation.clickAddButton();
    }

    @Then("The new asset type should be added successfully")
    public void newAssetTypeIsAddedSuccessfully() {
        implementation.verifyAssetTypeAdded();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}