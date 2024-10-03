package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the MyMIS login page {string}")
    public void userIsOnMyMISLoginPage(String url) {
        implementation.launchUrl(url);
    }

    @When("User enters user id {string} in the username field")
    public void userEntersUserId(String username) {
        implementation.enterUsername(username);
    }

    @And("User enters password {string} in the password field")
    public void userEntersPassword(String password) {
        implementation.enterPassword(password);
    }

    @And("User clicks on the login button")
    public void userClicksOnLoginButton() {
        implementation.clickLoginButton();
    }

    @Given("User navigates to {string}")
    public void userNavigatesTo(String menuItem) {
        implementation.navigateToMenuItem(menuItem);
    }

    @And("User clicks on {string}")
    public void userClicksOn(String subMenuItem) {
        implementation.clickSubMenuItem(subMenuItem);
    }

    @Then("User should be redirected to the User Card Mapping page")
    public void userShouldBeRedirectedToUserCardMappingPage() {
        implementation.verifyUserCardMappingPage();
    }

    @When("User clicks on the export button")
    public void userClicksOnExportButton() {
        implementation.clickExportButton();
    }

    @And("User clicks on the Copy option")
    public void userClicksOnCopyOption() {
        implementation.clickCopyOption();
    }

    @And("User clicks on the Excel option")
    public void userClicksOnExcelOption() {
        implementation.clickExcelOption();
    }

    @Then("User verifies if Excel {string} file is downloaded")
    public void userVerifiesExcelFileDownloaded(String fileName) {
        implementation.verifyExcelFileDownloaded(fileName);
    }

    @When("User clicks on the Print button")
    public void userClicksOnPrintButton() {
        implementation.clickPrintButton();
    }

    @Then("User verifies if Print {string} works correctly")
    public void userVerifiesPrintWorksCorrectly(String fileName) {
        implementation.verifyPrintWorksCorrectly(fileName);
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}