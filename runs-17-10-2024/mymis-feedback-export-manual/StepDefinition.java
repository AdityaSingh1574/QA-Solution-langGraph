package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the MyMIS login page {string}")
    public void userIsOnTheMyMISLoginPage(String url) {
        implementation.launchUrl(url);
    }

    @When("User types user id {string}")
    public void userTypesUserId(String userId) {
        implementation.enterUserId(userId);
    }

    @When("User types password {string}")
    public void userTypesPassword(String password) {
        implementation.enterPassword(password);
    }

    @When("User clicks login button")
    public void userClicksLoginButton() {
        implementation.clickLoginButton();
    }

    @Given("User navigates to {string} under ec-dc management")
    public void userNavigatesToUnderEcDcManagement(String menuItem) {
        implementation.navigateToQuarterlyFeedback();
    }

    @When("User selects the first option from financial year dropdown")
    public void userSelectsTheFirstOptionFromFinancialYearDropdown() {
        implementation.selectFirstFinancialYear();
    }

    @When("User selects Finadvisor from Delivery council dropdown")
    public void userSelectsFinadvisorFromDeliveryCouncilDropdown() {
        implementation.selectFinadvisorFromDeliveryCouncil();
    }

    @When("User changes the number of entries to {int}")
    public void userChangesTheNumberOfEntriesTo(Integer entries) {
        implementation.changeNumberOfEntries(entries);
    }

    @When("User clicks on export button to download")
    public void userClicksOnExportButtonToDownload() {
        implementation.clickExportButton();
    }

    @When("User clicks on user manual button")
    public void userClicksOnUserManualButton() {
        implementation.clickUserManualButton();
    }

    @Then("User should be redirected to {string}")
    public void userShouldBeRedirectedTo(String expectedUrl) {
        implementation.verifyRedirection(expectedUrl);
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}