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

    @Then("User should be redirected to the MyMIS homepage")
    public void userShouldBeRedirectedToHomepage() {
        implementation.verifyHomepageRedirect();
    }

    @Given("User navigates to appraisal cycle in appraisal")
    public void userNavigatesToAppraisalCycle() {
        implementation.navigateToAppraisalCycle();
    }

    @Then("User should be redirected to the Appraisal Cycle page")
    public void userShouldBeRedirectedToAppraisalCyclePage() {
        implementation.verifyAppraisalCyclePage();
    }

    @When("User selects the appraisal month as {int} for the first appraisal cycle")
    public void userSelectsAppraisalMonth(int year) {
        implementation.selectAppraisalMonth(year);
    }

    @When("User clicks save button for the appraisal cycle")
    public void userClicksSaveButton() {
        implementation.clickSaveButton();
    }

    @Then("User should be redirected to the updated Appraisal Cycle page")
    public void userShouldBeRedirectedToUpdatedAppraisalCyclePage() {
        implementation.verifyUpdatedAppraisalCyclePage();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}