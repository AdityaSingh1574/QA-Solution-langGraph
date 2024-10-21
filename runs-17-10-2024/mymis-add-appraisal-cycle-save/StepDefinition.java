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

    @When("User clicks 'Add New' button")
    public void userClicksAddNewButton() {
        implementation.clickAddNewButton();
    }

    @When("User selects country as India from dropdown")
    public void userSelectsCountry() {
        implementation.selectCountry("India");
    }

    @When("User selects year as 2021 from dropdown")
    public void userSelectsYear() {
        implementation.selectYear("2021");
    }

    @When("User selects month as July from dropdown")
    public void userSelectsMonth() {
        implementation.selectMonth("July");
    }

    @When("User clicks 'Save' button")
    public void userClicksSaveButton() {
        implementation.clickSaveButton();
    }

    @Then("User should be redirected to the Appraisal Cycle page")
    public void userShouldBeRedirectedToAppraisalCyclePage() {
        implementation.verifyAppraisalCyclePageRedirect();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}