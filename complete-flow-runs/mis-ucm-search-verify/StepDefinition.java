package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        implementation.launchUrl();
    }

    @When("I enter the username {string}")
    public void iEnterTheUsername(String username) {
        implementation.enterUsername(username);
    }

    @And("I enter the password {string}")
    public void iEnterThePassword(String password) {
        implementation.enterPassword(password);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        implementation.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {
        implementation.verifySuccessfulLogin();
    }

    @When("I navigate to {string}")
    public void iNavigateTo(String menuItem) {
        implementation.navigateToMenuItem(menuItem);
    }

    @And("I click on {string}")
    public void iClickOn(String subMenuItem) {
        implementation.clickOnSubMenuItem(subMenuItem);
    }

    @And("I type {string} in the search bar")
    public void iTypeInTheSearchBar(String searchText) {
        implementation.enterSearchText(searchText);
    }

    @And("I press enter")
    public void iPressEnter() {
        implementation.pressEnterInSearchBar();
    }

    @Then("I should see search results for {string}")
    public void iShouldSeeSearchResultsFor(String searchText) {
        implementation.verifySearchResults(searchText);
    }

    @And("the search results should contain relevant information for {string}")
    public void theSearchResultsShouldContainRelevantInformationFor(String searchText) {
        implementation.verifyRelevantInformation(searchText);
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}