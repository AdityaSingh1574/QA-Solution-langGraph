package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the login page")
    public void userIsOnLoginPage() {
        implementation.launchUrl();
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

    @Then("User should be redirected to the dashboard")
    public void userRedirectedToDashboard() {
        implementation.verifyDashboardRedirection();
    }

    @Given("User navigates to Employee appraisal under appraisal management")
    public void userNavigatesToEmployeeAppraisal() {
        implementation.navigateToEmployeeAppraisal();
    }

    @Then("User should be redirected to the appraisal management page")
    public void userRedirectedToAppraisalManagementPage() {
        implementation.verifyAppraisalManagementPage();
    }

    @When("User selects appraisal cycle as {string} from the dropdown")
    public void userSelectsAppraisalCycle(String cycle) {
        implementation.selectAppraisalCycle(cycle);
    }

    @When("User leaves appraisal status as default")
    public void userLeavesAppraisalStatusAsDefault() {
        // No action needed as it's left as default
    }

    @When("User leaves Dc manager as default")
    public void userLeavesDcManagerAsDefault() {
        // No action needed as it's left as default
    }

    @When("User selects Dc chair as {string} from the dropdown")
    public void userSelectsDcChair(String dcChair) {
        implementation.selectDcChair(dcChair);
    }

    @When("User clicks on the search button")
    public void userClicksSearchButton() {
        implementation.clickSearchButton();
    }

    @Then("User should be redirected to the Employees Appraisal page")
    public void userRedirectedToEmployeesAppraisalPage() {
        implementation.verifyEmployeesAppraisalPage();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}