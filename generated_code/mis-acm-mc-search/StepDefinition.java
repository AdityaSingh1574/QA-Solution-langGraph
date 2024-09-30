package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("the user is on the MIS login page")
    public void userIsOnMISLoginPage() {
        implementation.launchUrl("https://mymis.geminisolutions.com/");
    }

    @When("the user enters username {string} and password {string}")
    public void userEntersCredentials(String username, String password) {
        implementation.enterCredentials(username, password);
    }

    @When("the user clicks on the Signin button")
    public void userClicksSigninButton() {
        implementation.clickSigninButton();
    }

    @Then("the user should be navigated to the MIS homepage")
    public void userNavigatesToMISHomepage() {
        implementation.verifyMISHomepage();
    }

    @Given("the user is on the MIS homepage")
    public void userIsOnMISHomepage() {
        // This step is already covered by the previous step
    }

    @When("the user navigates to {string} and then {string}")
    public void userNavigatesToManageAccessCard(String menu, String submenu) {
        implementation.navigateToManageAccessCard(menu, submenu);
    }

    @Then("the user is redirected to the {string} page")
    public void userIsRedirectedToManageAccessCardPage(String pageName) {
        implementation.verifyManageAccessCardPage(pageName);
    }

    @When("the user searches for card number {string} in the search input")
    public void userSearchesForCardNumber(String cardNumber) {
        implementation.searchForCardNumber(cardNumber);
    }

    @Then("the search function should display results for card number {string}")
    public void searchFunctionDisplaysResults(String cardNumber) {
        implementation.verifySearchResults(cardNumber);
    }

    @Then("the search results should accurately match the entered card number {string}")
    public void searchResultsMatchCardNumber(String cardNumber) {
        implementation.verifySearchResultsAccuracy(cardNumber);
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}