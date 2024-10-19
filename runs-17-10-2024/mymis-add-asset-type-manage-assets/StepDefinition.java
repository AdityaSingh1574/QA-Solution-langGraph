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

    @Then("User should be redirected to the MIS homepage")
    public void userRedirectedToHomepage() {
        implementation.verifyHomepage();
    }

    @Given("User is on the MIS homepage")
    public void userIsOnMISHomepage() {
        // This step is already covered by the previous step
    }

    @When("User navigates to {string} menu")
    public void userNavigatesToMenu(String menuName) {
        implementation.navigateToMenu(menuName);
    }

    @And("User clicks on {string} option")
    public void userClicksOnOption(String option) {
        implementation.clickOnOption(option);
    }

    @Then("User should be redirected to the Manage Assets page")
    public void userRedirectedToManageAssetsPage() {
        implementation.verifyManageAssetsPage();
    }

    @When("User clicks on {string} button")
    public void userClicksOnButton(String buttonName) {
        implementation.clickOnButton(buttonName);
    }

    @And("User enters {string} in the asset type field")
    public void userEntersAssetType(String assetType) {
        implementation.enterAssetType(assetType);
    }

    @And("User selects {string} for {string} option from the dropdown")
    public void userSelectsOptionFromDropdown(String value, String dropdownName) {
        implementation.selectFromDropdown(dropdownName, value);
    }

    @Then("The new asset type should be added successfully")
    public void newAssetTypeAddedSuccessfully() {
        implementation.verifyAssetTypeAdded();
    }
}