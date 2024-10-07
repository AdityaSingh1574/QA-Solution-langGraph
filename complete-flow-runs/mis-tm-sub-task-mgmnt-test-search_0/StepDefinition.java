package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the MIS login page {string}")
    public void userIsOnMISLoginPage(String url) {
        implementation.launchUrl(url);
    }

    @When("User enters user id {string}")
    public void userEntersUserId(String userId) {
        implementation.enterUserId(userId);
    }

    @And("User enters password {string}")
    public void userEntersPassword(String password) {
        implementation.enterPassword(password);
    }

    @And("User clicks the login button")
    public void userClicksLoginButton() {
        implementation.clickLoginButton();
    }

    @Given("User navigates to {string} under task management")
    public void userNavigatesToManageTeamTask(String menuItem) {
        implementation.navigateToManageTeamTask(menuItem);
    }

    @And("User is redirected to the MIS homepage")
    public void userIsRedirectedToMISHomepage() {
        implementation.verifyRedirectionToHomepage();
    }

    @When("User navigates to the Manage Task Team page")
    public void userNavigatesToManageTaskTeamPage() {
        implementation.navigateToManageTaskTeamPage();
    }

    @And("User changes the entries to {int}")
    public void userChangesEntries(int entries) {
        implementation.changeEntries(entries);
    }

    @And("User searches for {string}")
    public void userSearchesFor(String searchTerm) {
        implementation.searchFor(searchTerm);
    }

    @And("User presses enter")
    public void userPressesEnter() {
        implementation.pressEnter();
    }

    @Then("User should see the search results for {string}")
    public void userShouldSeeSearchResults(String searchTerm) {
        implementation.verifySearchResults(searchTerm);
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}