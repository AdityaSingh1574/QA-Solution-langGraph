package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("user is on the MIS homepage")
    public void userIsOnMISHomepage() {
        implementation.launchUrl();
    }

    @When("user navigates on {string} and then {string}")
    public void userNavigatesTo(String mainMenu, String subMenu) {
        implementation.navigateToUserCardMapping(mainMenu, subMenu);
    }

    @When("User click on export button")
    public void userClicksOnExportButton() {
        implementation.clickExportButton();
    }

    @When("User click on Copy option")
    public void userClicksOnCopyOption() {
        implementation.clickCopyOption();
    }

    @Then("the user card mapping data should be copied to clipboard")
    public void verifyDataCopiedToClipboard() {
        implementation.verifyDataCopied();
    }

    @When("User click on Excel option")
    public void userClicksOnExcelOption() {
        implementation.clickExcelOption();
    }

    @Then("User verifies if Excel {string} got downloaded")
    public void verifyExcelDownloaded(String fileName) {
        implementation.verifyExcelDownloaded(fileName);
    }

    @When("User click on Print button")
    public void userClicksOnPrintButton() {
        implementation.clickPrintButton();
    }

    @Then("User verifies if Print {string} works")
    public void verifyPrintWorks(String fileName) {
        implementation.verifyPrintWorks(fileName);
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}