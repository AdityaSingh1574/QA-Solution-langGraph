package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the MIS login page {string}")
    public void userIsOnMISLoginPage(String url) {
        implementation.launchUrl(url);
    }

    @When("User enters user id {string} in the username field")
    public void userEntersUsername(String username) {
        implementation.enterUsername(username);
    }

    @When("User enters password {string} in the password field")
    public void userEntersPassword(String password) {
        implementation.enterPassword(password);
    }

    @When("User clicks on the login button")
    public void userClicksLoginButton() {
        implementation.clickLoginButton();
    }

    @Given("User is redirected to the MIS homepage")
    public void userIsRedirectedToMISHomepage() {
        implementation.verifyHomepage();
    }

    @When("User navigates to {string} under task management")
    public void userNavigatesToManageTeamTask(String linkText) {
        implementation.navigateToManageTeamTask(linkText);
    }

    @Then("User is redirected to the Manage Task Team page")
    public void userIsRedirectedToManageTaskTeamPage() {
        implementation.verifyManageTaskTeamPage();
    }

    @When("User changes entries to {int}")
    public void userChangesEntries(int entries) {
        implementation.changeEntries(entries);
    }

    @When("User enters {string} in the search input field")
    public void userEntersSearchInput(String searchText) {
        implementation.enterSearchInput(searchText);
    }

    @When("User presses enter")
    public void userPressesEnter() {
        implementation.pressEnter();
    }

    @Then("User should see the filtered results for {string}")
    public void userSeesFilteredResults(String searchText) {
        implementation.verifyFilteredResults(searchText);
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}