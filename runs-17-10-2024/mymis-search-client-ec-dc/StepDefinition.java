package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    public Implementation implementation = new Implementation();

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

    @Given("User navigates to client management under ec-dc management")
    public void userNavigatesToClientManagement() {
        implementation.navigateToClientManagement();
    }

    @And("User is redirected to the MyMIS homepage")
    public void userIsRedirectedToHomepage() {
        implementation.verifyHomepageRedirect();
    }

    @When("User searches for {string} in the search input")
    public void userSearchesForClient(String clientName) {
        implementation.searchForClient(clientName);
    }

    @And("User presses enter")
    public void userPressesEnter() {
        implementation.pressEnterKey();
    }

    @Then("User is redirected to the Manage Client page")
    public void userIsRedirectedToManageClientPage() {
        implementation.verifyManageClientPageRedirect();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}