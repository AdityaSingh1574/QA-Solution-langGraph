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

    @When("User enters user id as {string}")
    public void userEntersUserId(String userId) {
        implementation.enterUserId(userId);
    }

    @When("User enters password as {string}")
    public void userEntersPassword(String password) {
        implementation.enterPassword(password);
    }

    @When("User clicks on the login button")
    public void userClicksLoginButton() {
        implementation.clickLoginButton();
    }

    @Then("User should be logged in successfully")
    public void userShouldBeLoggedIn() {
        implementation.verifySuccessfulLogin();
    }

    @Given("User navigates to Parameter Master under Appraisal")
    public void userNavigatesToParameterMaster() {
        implementation.navigateToParameterMaster();
    }

    @When("User selects {string} from Appraisal Cycle dropdown")
    public void userSelectsAppraisalCycle(String cycle) {
        implementation.selectAppraisalCycle(cycle);
    }

    @When("User selects {string} from Location dropdown")
    public void userSelectsLocation(String location) {
        implementation.selectLocation(location);
    }

    @When("User selects {string} from Vertical dropdown")
    public void userSelectsVertical(String vertical) {
        implementation.selectVertical(vertical);
    }

    @When("User selects {string} from Designation dropdown")
    public void userSelectsDesignation(String designation) {
        implementation.selectDesignation(designation);
    }

    @When("User clicks on the search button")
    public void userClicksSearchButton() {
        implementation.clickSearchButton();
    }

    @Then("User should be redirected to the Parameter Master page")
    public void userShouldBeRedirectedToParameterMasterPage() {
        implementation.verifyParameterMasterPage();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}