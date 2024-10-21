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

    @Given("User navigates to Manage Team appraisal form under appraisal management")
    public void userNavigatesToManageTeamAppraisalForm() {
        implementation.navigateToManageTeamAppraisal();
    }

    @Then("User should be redirected to the Manage Team Appraisal page")
    public void userShouldBeRedirectedToTheManageTeamAppraisalPage() {
        implementation.verifyManageTeamAppraisalPage();
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

    @When("User selects Department {string} from dropdown")
    public void userSelectsDepartmentFromDropdown(String department) {
        implementation.selectDepartment(department);
    }

    @When("User clicks search button")
    public void userClicksSearchButton() {
        implementation.clickSearchButton();
    }

    @Then("User should see filtered results for team appraisal")
    public void userShouldSeeFilteredResultsForTeamAppraisal() {
        implementation.verifyFilteredResults();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}