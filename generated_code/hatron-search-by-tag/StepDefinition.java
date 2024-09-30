package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.junit.Assert;

public class StepDefinition {
    private Implementation implementation = new Implementation();
    private int initialCount;

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
        // This step is already covered by previous steps
    }

    @When("enter search text in Search by {string}")
    public void enterSearchText(String searchText) {
        initialCount = implementation.getCoursesCount();
        implementation.enterSearchText(searchText);
    }

    @Then("verify if records are filtered by checking the count of courses")
    public void verifyRecordsFiltered() {
        int filteredCount = implementation.getCoursesCount();
        Assert.assertTrue("Records should be filtered", filteredCount <= initialCount);
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}