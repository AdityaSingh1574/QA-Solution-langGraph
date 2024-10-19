package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the MyMIS login page {string}")
    public void userIsOnMyMISLoginPage(String url) {
        implementation.launchUrl(url);
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

    @Then("User should be redirected to the MyMIS homepage")
    public void userShouldBeRedirectedToMyMISHomepage() {
        implementation.verifyHomepageRedirection();
    }

    @Given("User navigates to team info under team management")
    public void userNavigatesToTeamInfo() {
        implementation.navigateToTeamInfo();
    }

    @And("User is redirected to the team management page")
    public void userIsRedirectedToTeamManagementPage() {
        implementation.verifyTeamManagementPage();
    }

    @When("User clicks view to view team")
    public void userClicksViewToViewTeam() {
        implementation.clickViewTeam();
    }

    @And("User clicks delete")
    public void userClicksDelete() {
        implementation.clickDelete();
    }

    @And("User confirms the deletion")
    public void userConfirmsDeletion() {
        implementation.confirmDeletion();
    }

    @Then("User should be redirected to the team information page")
    public void userShouldBeRedirectedToTeamInformationPage() {
        implementation.verifyTeamInformationPageRedirection();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}