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

<<<<<<< HEAD
    @When("User enters user id {string} in the username field")
    public void userEntersUsername(String username) {
        implementation.enterUsername(username);
    }

    @When("User enters password {string} in the password field")
=======
    @When("User enters user id {string}")
    public void userEntersUserId(String userId) {
        implementation.enterUserId(userId);
    }

    @And("User enters password {string}")
>>>>>>> 85e14be2bc9d6256e7a3058e34f4e0434adc401d
    public void userEntersPassword(String password) {
        implementation.enterPassword(password);
    }

<<<<<<< HEAD
    @When("User clicks on the login button")
=======
    @And("User clicks the login button")
>>>>>>> 85e14be2bc9d6256e7a3058e34f4e0434adc401d
    public void userClicksLoginButton() {
        implementation.clickLoginButton();
    }

<<<<<<< HEAD
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
=======
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
>>>>>>> 85e14be2bc9d6256e7a3058e34f4e0434adc401d
    public void userChangesEntries(int entries) {
        implementation.changeEntries(entries);
    }

<<<<<<< HEAD
    @When("User enters {string} in the search input field")
    public void userEntersSearchInput(String searchText) {
        implementation.enterSearchInput(searchText);
    }

    @When("User presses enter")
=======
    @And("User searches for {string}")
    public void userSearchesFor(String searchTerm) {
        implementation.searchFor(searchTerm);
    }

    @And("User presses enter")
>>>>>>> 85e14be2bc9d6256e7a3058e34f4e0434adc401d
    public void userPressesEnter() {
        implementation.pressEnter();
    }

<<<<<<< HEAD
    @Then("User should see the filtered results for {string}")
    public void userSeesFilteredResults(String searchText) {
        implementation.verifyFilteredResults(searchText);
=======
    @Then("User should see the search results for {string}")
    public void userShouldSeeSearchResults(String searchTerm) {
        implementation.verifySearchResults(searchTerm);
>>>>>>> 85e14be2bc9d6256e7a3058e34f4e0434adc401d
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}