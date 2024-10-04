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

    @When("user enters user id {string} in the username field")
    public void userEntersUsername(String username) {
        implementation.enterUsername(username);
    }

    @When("user enters password {string} in the password field")
    public void userEntersPassword(String password) {
        implementation.enterPassword(password);
    }

    @When("user clicks on the login button")
    public void userClicksLoginButton() {
        implementation.clickLoginButton();
    }

    @Then("user should be redirected to the MIS homepage")
    public void userRedirectedToHomepage() {
        implementation.verifyHomepage();
    }

    @Given("user is on the MIS homepage")
    public void userIsOnMISHomepage() {
        // This step is already covered by the previous step
    }

    @When("user navigates to {string} under task management")
    public void userNavigatesToManageTeamTask(String linkText) {
        implementation.navigateToManageTeamTask(linkText);
    }

    @Then("user should be redirected to the Manage Task Team page")
    public void userRedirectedToManageTaskTeamPage() {
        implementation.verifyManageTaskTeamPage();
    }

    @When("user changes entries to {int}")
    public void userChangesEntries(int entries) {
        implementation.changeEntries(entries);
    }

    @When("user enters {string} in the search input field")
    public void userEntersSearchQuery(String query) {
        implementation.enterSearchQuery(query);
    }

    @When("user presses enter")
    public void userPressesEnter() {
        implementation.pressEnter();
    }

    @Then("the search results should be displayed")
    public void searchResultsDisplayed() {
        implementation.verifySearchResults();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}