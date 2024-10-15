package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the MyMIS login page {string}")
    public void userIsOnLoginPage(String url) {
        implementation.launchUrl(url);
    }

    @When("User enters user id {string} in the username field")
    public void userEntersUsername(String username) {
        implementation.enterUsername(username);
    }

    @And("User enters password {string} in the password field")
    public void userEntersPassword(String password) {
        implementation.enterPassword(password);
    }

    @And("User clicks on the login button")
    public void userClicksLoginButton() {
        implementation.clickLoginButton();
    }

    @Then("User should be redirected to the MyMIS homepage")
    public void userIsRedirectedToHomepage() {
        implementation.verifyHomepage();
    }

    @Given("User is on the MyMIS homepage")
    public void userIsOnHomepage() {
        // This step is already covered by the previous step
    }

    @When("User navigates to {string} under task management")
    public void userNavigatesToManageTeamTask(String menuItem) {
        implementation.navigateToManageTeamTask();
    }

    @Then("User should be redirected to the Manage Task Team page")
    public void userIsRedirectedToManageTaskTeamPage() {
        implementation.verifyManageTaskTeamPage();
    }

    @When("User changes entries to {int}")
    public void userChangesEntries(Integer number) {
        implementation.changeEntries(number.toString());
    }

    @And("User enters {string} in the search input")
    public void userEntersSearchText(String searchText) {
        implementation.enterSearch(searchText);
    }

    @Then("The search results should be displayed")
    public void searchResultsAreDisplayed() {
        implementation.verifySearchResults();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}