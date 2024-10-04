package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

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

    @And("user enters password {string} in the password field")
    public void userEntersPassword(String password) {
        implementation.enterPassword(password);
    }

    @And("user clicks on the login button")
    public void userClicksLoginButton() {
        implementation.clickLoginButton();
    }

    @Then("user should be redirected to the MIS homepage")
    public void userRedirectedToHomepage() {
        implementation.verifyHomepage();
    }

    @Given("user is on the MIS homepage")
    public void userIsOnMISHomepage() {
        implementation.verifyHomepage();
    }

    @When("user navigates to {string}")
    public void userNavigatesToEmployeeDirectory(String menuItem) {
        implementation.navigateToMenuItem(menuItem);
    }

    @Then("user should be redirected to the Employee Directory page")
    public void userRedirectedToEmployeeDirectoryPage() {
        implementation.verifyEmployeeDirectoryPage();
    }

    @When("user clicks on the entries dropdown")
    public void userClicksEntriesDropdown() {
        implementation.clickEntriesDropdown();
    }

    @And("user selects {string} from the dropdown")
    public void userSelectsFromDropdown(String option) {
        implementation.selectDropdownOption(option);
    }

    @And("user enters {string} in the search bar")
    public void userEntersInSearchBar(String searchTerm) {
        implementation.enterSearchTerm(searchTerm);
    }

    @And("user presses enter")
    public void userPressesEnter() {
        implementation.pressEnter();
    }

    @Then("the search results for {string} should be displayed")
    public void searchResultsDisplayed(String searchTerm) {
        implementation.verifySearchResults(searchTerm);
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}