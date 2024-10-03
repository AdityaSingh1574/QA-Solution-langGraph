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

    @When("User enters user id {string} in the user id input field")
    public void userEntersUserId(String userId) {
        implementation.enterUserId(userId);
    }

    @And("User enters password {string} in the password input field")
    public void userEntersPassword(String password) {
        implementation.enterPassword(password);
    }

    @And("User clicks on the login button")
    public void userClicksLoginButton() {
        implementation.clickLoginButton();
    }

    @Given("User is on the MyMIS homepage")
    public void userIsOnMyMISHomepage() {
        implementation.verifyHomepage();
    }

    @When("User clicks on the export button")
    public void userClicksExportButton() {
        implementation.clickExportButton();
    }

    @And("User clicks on the Copy option")
    public void userClicksCopyOption() {
        implementation.clickCopyOption();
    }

    @And("User clicks on the Excel option")
    public void userClicksExcelOption() {
        implementation.clickExcelOption();
    }

    @Then("User verifies if Excel {string} file is downloaded")
    public void userVerifiesExcelFileDownload(String fileName) {
        implementation.verifyExcelFileDownload(fileName);
    }

    @When("User clicks on the Print button")
    public void userClicksPrintButton() {
        implementation.clickPrintButton();
    }

    @Then("User verifies if Print {string} works correctly")
    public void userVerifiesPrintFunctionality(String documentName) {
        implementation.verifyPrintFunctionality(documentName);
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}