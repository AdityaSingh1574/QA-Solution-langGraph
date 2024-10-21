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

    @Then("User should be redirected to the MIS homepage")
    public void userIsRedirectedToHomepage() {
        implementation.verifyHomepage();
    }

    @Given("User navigates to Parameter Master under Appraisal")
    public void userNavigatesToParameterMaster() {
        implementation.navigateToParameterMaster();
    }

    @Then("User should be redirected to the Parameter Master page")
    public void userIsRedirectedToParameterMasterPage() {
        implementation.verifyParameterMasterPage();
    }

    @When("User selects {string} from the competency dropdown")
    public void userSelectsCompetency(String competency) {
        implementation.selectCompetency(competency);
    }

    @When("User selects {string} from the year dropdown")
    public void userSelectsYear(String year) {
        implementation.selectYear(year);
    }

    @When("User selects {string} from the status dropdown")
    public void userSelectsStatus(String status) {
        implementation.selectStatus(status);
    }

    @When("User clicks on the search button")
    public void userClicksSearchButton() {
        implementation.clickSearchButton();
    }

    @Then("User should see the search results for Behavioral parameters")
    public void userSeesSearchResults() {
        implementation.verifySearchResults();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}