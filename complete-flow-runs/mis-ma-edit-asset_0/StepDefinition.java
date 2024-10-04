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

    @Then("User should be logged in successfully")
    public void userShouldBeLoggedIn() {
        implementation.verifyLogin();
    }

    @Given("User navigates to {string} section")
    public void userNavigatesToSection(String section) {
        implementation.navigateToSection(section);
    }

    @And("User clicks on {string}")
    public void userClicksOn(String link) {
        implementation.clickOnLink(link);
    }

    @Then("User should be redirected to the asset management page")
    public void userShouldBeRedirectedToAssetManagementPage() {
        implementation.verifyAssetManagementPage();
    }

    @When("User clicks on {string} button")
    public void userClicksOnButton(String buttonName) {
        implementation.clickOnButton(buttonName);
    }

    @And("User changes asset type to {string}")
    public void userChangesAssetType(String assetType) {
        implementation.changeAssetType(assetType);
    }

    @And("User updates serial number to {string}")
    public void userUpdatesSerialNumber(String serialNumber) {
        implementation.updateSerialNumber(serialNumber);
    }

    @And("User clicks on the update button")
    public void userClicksUpdateButton() {
        implementation.clickUpdateButton();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}