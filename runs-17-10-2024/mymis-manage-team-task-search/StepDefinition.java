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
        implementation.enterUsername(userId);
    }

    @And("User types password {string}")
    public void userTypesPassword(String password) {
        implementation.enterPassword(password);
    }

    @And("User clicks login button")
    public void userClicksLoginButton() {
        implementation.clickLoginButton();
    }

    @Given("User navigates to {string} under task management")
    public void userNavigatesToManageTeamTask(String linkText) {
        implementation.navigateToManageTeamTask(linkText);
    }

    @When("User changes the entries to {int}")
    public void userChangesEntries(int entries) {
        implementation.changeEntries(entries);
    }

    @And("User searches for {string}")
    public void userSearchesFor(String searchText) {
        implementation.searchForTask(searchText);
    }

    @And("User presses enter")
    public void userPressesEnter() {
        implementation.pressEnter();
    }

    @Then("User should be redirected to the Manage Task Team page")
    public void userShouldBeRedirectedToManageTaskTeamPage() {
        implementation.verifyManageTaskTeamPage();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}