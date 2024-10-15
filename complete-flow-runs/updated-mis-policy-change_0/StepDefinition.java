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

    @Given("User is redirected to the homepage")
    public void userIsRedirectedToHomepage() {
        implementation.verifyHomepage();
    }

    @When("User navigates to the Manage Policy page")
    public void userNavigatesToManagePolicyPage() {
        implementation.navigateToManagePolicyPage();
    }

    @Then("User is redirected to {string}")
    public void userIsRedirectedTo(String url) {
        implementation.verifyCurrentUrl(url);
    }

    @When("User clicks on the view policy button")
    public void userClicksViewPolicyButton() {
        implementation.clickViewPolicyButton();
    }

    @When("User clicks on the deactivate policy button")
    public void userClicksDeactivatePolicyButton() {
        implementation.clickDeactivatePolicyButton();
    }

    @When("User confirms by clicking yes")
    public void userConfirmsByClickingYes() {
        implementation.clickConfirmYesButton();
    }

    @When("User clicks on the delete policy button")
    public void userClicksDeletePolicyButton() {
        implementation.clickDeletePolicyButton();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}