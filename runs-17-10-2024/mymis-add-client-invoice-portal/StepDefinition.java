package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

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

    @When("User enters password {string} in the password field")
    public void userEntersPassword(String password) {
        implementation.enterPassword(password);
    }

    @When("User clicks on the login button")
    public void userClicksLoginButton() {
        implementation.clickLoginButton();
    }

    @Then("User should be redirected to the MyMIS homepage")
    public void userIsRedirectedToHomepage() {
        implementation.verifyHomepage();
    }

    @Given("User is on the MyMIS homepage")
    public void userIsOnHomepage() {
        implementation.verifyHomepage();
    }

    @When("User navigates to the invoice portal under Account portal")
    public void userNavigatesToInvoicePortal() {
        implementation.navigateToInvoicePortal();
    }

    @Then("User should be redirected to the invoice portal page")
    public void userIsRedirectedToInvoicePortal() {
        implementation.verifyInvoicePortalPage();
    }

    @When("User clicks on the 'Add new client' button")
    public void userClicksAddNewClientButton() {
        implementation.clickAddNewClientButton();
    }

    @When("User enters name {string} in the client name input field")
    public void userEntersClientName(String clientName) {
        implementation.enterClientName(clientName);
    }

    @When("User clicks on the save button")
    public void userClicksSaveButton() {
        implementation.clickSaveButton();
    }

    @Then("User should be redirected to the invoice report page")
    public void userIsRedirectedToInvoiceReportPage() {
        implementation.verifyInvoiceReportPage();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}