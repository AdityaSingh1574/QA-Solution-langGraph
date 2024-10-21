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

    @When("User types user id {string}")
    public void userTypesUserId(String userId) {
        implementation.enterUserId(userId);
    }

    @When("User types password {string}")
    public void userTypesPassword(String password) {
        implementation.enterPassword(password);
    }

    @When("User clicks login button")
    public void userClicksLoginButton() {
        implementation.clickLoginButton();
    }

    @Then("User should be redirected to the MyMIS homepage")
    public void userShouldBeRedirectedToTheMyMISHomepage() {
        implementation.verifyHomepage();
    }

    @Given("User is on the MyMIS homepage")
    public void userIsOnTheMyMISHomepage() {
        implementation.verifyHomepage();
    }

    @When("User navigates to competency form under appraisal management")
    public void userNavigatesToCompetencyForm() {
        implementation.navigateToCompetencyForm();
    }

    @Then("User should be redirected to the Competency Form page")
    public void userShouldBeRedirectedToTheCompetencyFormPage() {
        implementation.verifyCompetencyFormPage();
    }

    @When("User selects appraisal cycle {string} from dropdown")
    public void userSelectsAppraisalCycleFromDropdown(String cycle) {
        implementation.selectAppraisalCycle(cycle);
    }

    @When("User selects location {string} from dropdown")
    public void userSelectsLocationFromDropdown(String location) {
        implementation.selectLocation(location);
    }

    @When("User selects Vertical {string} from dropdown")
    public void userSelectsVerticalFromDropdown(String vertical) {
        implementation.selectVertical(vertical);
    }

    @When("User selects Designation {string} from dropdown")
    public void userSelectsDesignationFromDropdown(String designation) {
        implementation.selectDesignation(designation);
    }

    @When("User clicks search button")
    public void userClicksSearchButton() {
        implementation.clickSearchButton();
    }

    @Then("User should see the search results")
    public void userShouldSeeTheSearchResults() {
        implementation.verifySearchResults();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}