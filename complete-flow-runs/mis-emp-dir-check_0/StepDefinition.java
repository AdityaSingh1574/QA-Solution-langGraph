package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the MyMIS login page {string}")
    public void userIsOnTheMyMISLoginPage(String url) {
        implementation.launchUrl(url);
    }

    @When("User enters user id {string} in the username field")
    public void userEntersUserIdInTheUsernameField(String username) {
        implementation.enterUsername(username);
    }

    @When("User enters password {string} in the password field")
    public void userEntersPasswordInThePasswordField(String password) {
        implementation.enterPassword(password);
    }

    @When("User clicks on the login button")
    public void userClicksOnTheLoginButton() {
        implementation.clickLoginButton();
    }

    @Then("User should be redirected to the MyMIS homepage")
    public void userShouldBeRedirectedToTheMyMISHomepage() {
        implementation.verifyHomepage();
    }

    @Given("User is on the MyMIS homepage")
    public void userIsOnTheMyMISHomepage() {
        // This step is already covered by the previous step
    }

    @When("User clicks on the {string} menu item")
    public void userClicksOnTheMenuItem(String menuItem) {
        implementation.clickMenuItem(menuItem);
    }

    @Then("User should be redirected to the Employee Directory page")
    public void userShouldBeRedirectedToTheEmployeeDirectoryPage() {
        implementation.verifyEmployeeDirectoryPage();
    }

    @When("User selects {string} from the entries dropdown")
    public void userSelectsFromTheEntriesDropdown(String entries) {
        implementation.selectEntries(entries);
    }

    @When("User types {string} in the search bar")
    public void userTypesInTheSearchBar(String searchTerm) {
        implementation.enterSearchTerm(searchTerm);
    }

    @When("User presses enter")
    public void userPressesEnter() {
        implementation.pressEnter();
    }

    @Then("User should see the search results for {string}")
    public void userShouldSeeTheSearchResultsFor(String searchTerm) {
        implementation.verifySearchResults(searchTerm);
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}