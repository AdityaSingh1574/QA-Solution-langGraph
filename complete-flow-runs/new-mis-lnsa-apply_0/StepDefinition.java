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

    @When("User types user id {string}")
    public void userTypesUserId(String userId) {
        implementation.enterUsername(userId);
    }

    @When("User types password {string}")
    public void userTypesPassword(String password) {
        implementation.enterPassword(password);
    }

    @When("User clicks login button")
    public void userClicksLoginButton() {
        implementation.clickLoginButton();
    }

    @Then("User should be redirected to the MIS homepage")
    public void userShouldBeRedirectedToMISHomepage() {
        implementation.verifyHomepage();
    }

    @Given("User navigates to apply under LNSA")
    public void userNavigatesToApplyUnderLNSA() {
        implementation.navigateToApplyLNSA();
    }

    @When("User checks week {int} for LNSA")
    public void userChecksWeekForLNSA(int weekNumber) {
        implementation.checkWeekForLNSA(weekNumber);
    }

    @When("User clicks submit button")
    public void userClicksSubmitButton() {
        implementation.clickSubmitButton();
    }

    @When("User enters the reason as {string}")
    public void userEntersReason(String reason) {
        implementation.enterReason(reason);
    }

    @When("User clicks final submit button")
    public void userClicksFinalSubmitButton() {
        implementation.clickFinalSubmitButton();
    }

    @Then("User should be redirected to the LNSA application page")
    public void userShouldBeRedirectedToLNSAApplicationPage() {
        implementation.verifyLNSAApplicationPage();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}