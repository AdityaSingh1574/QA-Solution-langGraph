package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("the user is on the {string} page")
    public void userIsOnPage(String pageName) {
        implementation.navigateToPage(pageName);
    }

    @When("user navigates to {string} section")
    public void userNavigatesToSection(String sectionName) {
        implementation.navigateToSection(sectionName);
    }

    @When("User clicks on the export button")
    public void userClicksOnExportButton() {
        implementation.clickExportButton();
    }

    @Then("User should see export options")
    public void userShouldSeeExportOptions() {
        implementation.verifyExportOptions();
    }

    @When("User clicks on Copy option")
    public void userClicksOnCopyOption() {
        implementation.clickCopyOption();
    }

    @Then("the access card information should be copied to clipboard")
    public void accessCardInfoCopiedToClipboard() {
        implementation.verifyClipboardContent();
    }

    @When("User clicks on Excel option")
    public void userClicksOnExcelOption() {
        implementation.clickExcelOption();
    }

    @Then("an Excel file named {string} should be downloaded")
    public void excelFileDownloaded(String fileName) {
        implementation.verifyFileDownloaded(fileName);
    }

    @Then("User verifies if Excel {string} file got downloaded successfully")
    public void verifyExcelFileDownloaded(String fileName) {
        implementation.verifyExcelFileContent(fileName);
    }

    @When("User clicks on Print button")
    public void userClicksOnPrintButton() {
        implementation.clickPrintButton();
    }

    @Then("a print dialog for {string} should open")
    public void printDialogOpens(String documentName) {
        implementation.verifyPrintDialogOpened(documentName);
    }

    @Then("User verifies if Print {string} works correctly")
    public void verifyPrintFunctionality(String documentName) {
        implementation.verifyPrintFunctionality(documentName);
    }
}