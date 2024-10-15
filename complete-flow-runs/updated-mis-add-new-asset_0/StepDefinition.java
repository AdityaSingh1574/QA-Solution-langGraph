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

    @And("User clicks on the Manage Assets option")
    public void userClicksManageAssets() {
        implementation.clickManageAssets();
    }

    @Then("User should be redirected to the Asset Management page")
    public void userIsRedirectedToAssetManagement() {
        implementation.verifyAssetManagementPage();
    }

    @When("User clicks on the Add new asset type button")
    public void userClicksAddNewAssetType() {
        implementation.clickAddNewAssetType();
    }

    @And("User enters {string} in the asset type field")
    public void userEntersAssetType(String assetType) {
        implementation.enterAssetType(assetType);
    }

    @And("User selects {string} from the Is temporary dropdown")
    public void userSelectsIsTemporary(String option) {
        implementation.selectIsTemporary(option);
    }

    @And("User clicks on the add button")
    public void userClicksAddButton() {
        implementation.clickAddButton();
    }

    @Then("The new asset type should be added successfully")
    public void newAssetTypeIsAdded() {
        implementation.verifyAssetTypeAdded();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}