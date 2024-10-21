package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the login page {string}")
    public void userIsOnLoginPage(String url) {
        implementation.launchUrl(url);
    }

    @When("User enters user id {string}")
    public void userEntersUserId(String userId) {
        implementation.enterUserId(userId);
    }

    @And("User enters password {string}")
    public void userEntersPassword(String password) {
        implementation.enterPassword(password);
    }

    @And("User clicks on the login button")
    public void userClicksOnLoginButton() {
        implementation.clickLoginButton();
    }

    @Then("User should be redirected to the homepage")
    public void userShouldBeRedirectedToHomepage() {
        implementation.verifyHomepage();
    }

    @Given("User navigates to Manage department/teams under HR Portal")
    public void userNavigatesToManageDepartmentTeams() {
        implementation.navigateToManageDepartmentTeams();
    }

    @When("User clicks on 'Add Department' button")
    public void userClicksOnAddDepartmentButton() {
        implementation.clickAddDepartmentButton();
    }

    @And("User enters department name as {string}")
    public void userEntersDepartmentName(String departmentName) {
        implementation.enterDepartmentName(departmentName);
    }

    @And("User enters department description as {string}")
    public void userEntersDepartmentDescription(String description) {
        implementation.enterDepartmentDescription(description);
    }

    @And("User clicks on department head dropdown")
    public void userClicksOnDepartmentHeadDropdown() {
        implementation.clickDepartmentHeadDropdown();
    }

    @And("User selects {string} from the dropdown")
    public void userSelectsFromDropdown(String option) {
        implementation.selectFromDropdown(option);
    }

    @And("User clicks on division name dropdown")
    public void userClicksOnDivisionNameDropdown() {
        implementation.clickDivisionNameDropdown();
    }

    @And("User clicks on 'Add' button")
    public void userClicksOnAddButton() {
        implementation.clickAddButton();
    }

    @Then("User should be redirected to the Manage Department page")
    public void userShouldBeRedirectedToManageDepartmentPage() {
        implementation.verifyManageDepartmentPage();
    }
}