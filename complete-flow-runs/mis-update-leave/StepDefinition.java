package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the MyMIS login page {string}")
    public void userIsOnMyMISLoginPage(String url) {
        implementation.launchUrl(url);
    }

    @When("User enters user id {string}")
    public void userEntersUserId(String userId) {
        implementation.enterUserId(userId);
    }

    @When("User enters password {string}")
    public void userEntersPassword(String password) {
        implementation.enterPassword(password);
    }

    @When("User clicks on the login button")
    public void userClicksOnLoginButton() {
        implementation.clickLoginButton();
    }

    @Then("User should be redirected to the MyMIS homepage")
    public void userShouldBeRedirectedToMyMISHomepage() {
        implementation.verifyHomepage();
    }

    @Given("User is on the MyMIS homepage")
    public void userIsOnMyMISHomepage() {
        // This step is already covered by the previous step
    }

    @When("User navigates to update on leave management")
    public void userNavigatesToUpdateOnLeaveManagement() {
        implementation.navigateToLeaveManagement();
    }

    @Then("User should be redirected to the Leave Management Update page")
    public void userShouldBeRedirectedToLeaveManagementUpdatePage() {
        implementation.verifyLeaveManagementPage();
    }

    @When("User selects the first option from Financial year dropdown")
    public void userSelectsFirstOptionFromFinancialYearDropdown() {
        implementation.selectFirstFinancialYear();
    }

    @When("User selects employee status as Active")
    public void userSelectsEmployeeStatusAsActive() {
        implementation.selectActiveEmployeeStatus();
    }

    @When("User searches for employee {string}")
    public void userSearchesForEmployee(String employeeName) {
        implementation.searchForEmployee(employeeName);
    }

    @When("User selects employee {string}")
    public void userSelectsEmployee(String employeeName) {
        implementation.selectEmployee(employeeName);
    }

    @When("User clicks on {string} button")
    public void userClicksOnButton(String buttonName) {
        implementation.clickApplyLeaveButton();
    }

    @Then("User should be redirected to the Leave Application page")
    public void userShouldBeRedirectedToLeaveApplicationPage() {
        implementation.verifyLeaveApplicationPage();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}