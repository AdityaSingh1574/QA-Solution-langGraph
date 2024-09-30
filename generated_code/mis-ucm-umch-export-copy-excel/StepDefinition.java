package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("user is on the MIS homepage")
    public void userIsOnMISHomepage() {
        implementation.launchUrl("https://mymis.geminisolutions.com/");
    }

    @When("user navigates on {string} and then {string}")
    public void userNavigatesTo(String menu, String submenu) {
        implementation.navigateToUserCardMapping(menu, submenu);
    }

    @And("User goes to Unmapped card history")
    public void userGoesToUnmappedCardHistory() {
        implementation.goToUnmappedCardHistory();
    }

    @When("User click on export button two")
    public void userClicksOnExportButton() {
        implementation.clickExportButton();
    }

    @And("User click on Copy option two")
    public void userClicksOnCopyOption() {
        implementation.clickCopyOption();
    }

    @Then("the unmapped card data should be copied to clipboard")
    public void verifyDataCopiedToClipboard() {
        implementation.verifyDataCopiedToClipboard();
    }

    @When("User click on Excel option two")
    public void userClicksOnExcelOption() {
        implementation.clickExcelOption();
    }

    @Then("User verifies if Excel {string} got downloaded")
    public void verifyExcelDownloaded(String fileName) {
        implementation.verifyExcelDownloaded(fileName);
    }

    @When("User click on Print button two")
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