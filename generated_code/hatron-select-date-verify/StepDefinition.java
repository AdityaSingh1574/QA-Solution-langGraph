package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the login page at {}")
    public void userIsOnLoginPage(String url) {
        implementation.launchUrl(url);
    }

    @When("User selects Email option for login")
    public void userSelectsEmailOption() {
        implementation.selectEmailOption();
    }

    @And("User types Email {string}")
    public void userTypesEmail(String email) {
        implementation.enterEmail(email);
    }

    @And("User types password {string}")
    public void userTypesPassword(String password) {
        implementation.enterPassword(password);
    }

    @And("User clicks on Login button")
    public void userClicksLoginButton() {
        implementation.clickLoginButton();
    }

    @And("User clicks on the hamburger button")
    public void userClicksHamburgerButton() {
        implementation.clickHamburgerButton();
    }

    @And("User clicks on Tests dropdown")
    public void userClicksTestsDropdown() {
        implementation.clickTestsDropdown();
    }

    @And("User selects Test controls")
    public void userSelectsTestControls() {
        implementation.selectTestControls();
    }

    @Given("user is on TestControl screen")
    public void userIsOnTestControlScreen() {
        // This step is implicit after the previous steps
    }

    @When("user clicks on the start date selection button")
    public void userClicksStartDateSelectionButton() {
        implementation.clickStartDateSelectionButton();
    }

    @And("user selects the start date")
    public void userSelectsStartDate() {
        implementation.selectStartDate();
    }

    @And("user clicks on the end date selection button")
    public void userClicksEndDateSelectionButton() {
        implementation.clickEndDateSelectionButton();
    }

    @And("user selects the end date")
    public void userSelectsEndDate() {
        implementation.selectEndDate();
    }

    @Then("the records should be filtered based on the selected date range")
    public void recordsShouldBeFiltered() {
        // This step is implicit and verified in the next step
    }

    @And("user should see the filtered records count")
    public void userShouldSeeFilteredRecordsCount() {
        assert implementation.verifyFilteredRecords() : "Filtered records count is not displayed";
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}