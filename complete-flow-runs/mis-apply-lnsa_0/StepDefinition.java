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

    @When("User enters user id {string}")
    public void userEntersUserId(String userId) {
        implementation.enterUserId(userId);
    }

    @When("User enters password {string}")
    public void userEntersPassword(String password) {
        implementation.enterPassword(password);
    }

    @When("User clicks on the login button")
    public void userClicksOnTheLoginButton() {
        implementation.clickLoginButton();
    }

    @Given("User is redirected to the MyMIS homepage")
    public void userIsRedirectedToTheMyMISHomepage() {
        implementation.verifyHomepage();
    }

    @When("User navigates to the Apply section under LNSA")
    public void userNavigatesToTheApplySectionUnderLNSA() {
        implementation.navigateToLNSAApply();
    }

    @Then("User is redirected to the LNSA Apply page")
    public void userIsRedirectedToTheLNSAApplyPage() {
        implementation.verifyLNSAApplyPage();
    }

    @When("User checks the checkbox for week {int}")
    public void userChecksTheCheckboxForWeek(Integer weekNumber) {
        implementation.checkWeekCheckbox(weekNumber);
    }

    @When("User clicks on the submit button")
    public void userClicksOnTheSubmitButton() {
        implementation.clickSubmitButton();
    }

    @When("User enters the reason {string}")
    public void userEntersTheReason(String reason) {
        implementation.enterReason(reason);
    }

    @When("User clicks on the final submit button")
    public void userClicksOnTheFinalSubmitButton() {
        implementation.clickFinalSubmitButton();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}