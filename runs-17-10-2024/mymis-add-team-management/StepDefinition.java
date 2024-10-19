package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("user is on the MIS login page {string}")
    public void userIsOnMISLoginPage(String url) {
        implementation.launchUrl(url);
    }

    @When("user enters user id {string}")
    public void userEntersUserId(String userId) {
        implementation.enterUserId(userId);
    }

    @When("user enters password {string}")
    public void userEntersPassword(String password) {
        implementation.enterPassword(password);
    }

    @When("user clicks on the login button")
    public void userClicksOnLoginButton() {
        implementation.clickLoginButton();
    }

    @Then("user should be redirected to the MIS homepage")
    public void userShouldBeRedirectedToMISHomepage() {
        implementation.verifyHomepageRedirect();
    }

    @Given("user navigates to team info under team management")
    public void userNavigatesToTeamInfo() {
        implementation.navigateToTeamInfo();
    }

    @Then("user should be redirected to the Team Information page")
    public void userShouldBeRedirectedToTeamInformationPage() {
        implementation.verifyTeamInformationPage();
    }

    @When("user enters team name as {string}")
    public void userEntersTeamName(String teamName) {
        implementation.enterTeamName(teamName);
    }

    @When("user selects weak start day as {string} from the dropdown")
    public void userSelectsWeekStartDay(String weekStartDay) {
        implementation.selectWeekStartDay(weekStartDay);
    }

    @When("user selects department as {string} from the dropdown")
    public void userSelectsDepartment(String department) {
        implementation.selectDepartment(department);
    }

    @When("user selects team head as {string} from the dropdown")
    public void userSelectsTeamHead(String teamHead) {
        implementation.selectTeamHead(teamHead);
    }

    @When("user clicks on the save button")
    public void userClicksOnSaveButton() {
        implementation.clickSaveButton();
    }

    @Then("the new team should be created successfully")
    public void newTeamShouldBeCreatedSuccessfully() {
        implementation.verifyTeamCreation();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}