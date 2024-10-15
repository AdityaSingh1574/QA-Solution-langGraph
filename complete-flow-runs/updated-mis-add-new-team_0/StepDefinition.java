package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the login page")
    public void userIsOnLoginPage() {
        implementation.launchUrl();
    }

    @When("User types user id {string}")
    public void userTypesUserId(String userId) {
        implementation.enterUserId(userId);
    }

    @And("User types password {string}")
    public void userTypesPassword(String password) {
        implementation.enterPassword(password);
    }

    @And("User clicks login button")
    public void userClicksLoginButton() {
        implementation.clickLoginButton();
    }

    @Given("User navigates to team info under team management")
    public void userNavigatesToTeamInfo() {
        implementation.navigateToTeamInfo();
    }

    @And("User is redirected to the dashboard")
    public void userIsRedirectedToDashboard() {
        implementation.verifyDashboardRedirection();
    }

    @When("User enters team name as {string}")
    public void userEntersTeamName(String teamName) {
        implementation.enterTeamName(teamName);
    }

    @And("User selects weak start day as Tuesday")
    public void userSelectsWeekStartDay() {
        implementation.selectWeekStartDay("Tuesday");
    }

    @And("User selects department as data science")
    public void userSelectsDepartment() {
        implementation.selectDepartment("data science");
    }

    @And("User selects team head as 123 user")
    public void userSelectsTeamHead() {
        implementation.selectTeamHead("123 user");
    }

    @And("User clicks save button")
    public void userClicksSaveButton() {
        implementation.clickSaveButton();
    }

    @Then("User should be redirected to the Team Information page")
    public void userShouldBeRedirectedToTeamInformationPage() {
        implementation.verifyTeamInformationPageRedirection();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}