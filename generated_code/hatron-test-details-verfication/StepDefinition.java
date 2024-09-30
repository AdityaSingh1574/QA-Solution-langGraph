package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.junit.Assert;

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
        // This step is already covered by previous steps
    }

    @When("user clicks on the first Test to get test details")
    public void userClicksFirstTest() {
        implementation.clickFirstTest();
    }

    @Then("the test details screen should be displayed")
    public void testDetailsScreenShouldBeDisplayed() {
        Assert.assertTrue("Test details screen is not displayed", implementation.isTestDetailsScreenDisplayed());
    }

    @And("the test URL should be printed")
    public void testUrlShouldBePrinted() {
        String testUrl = implementation.getTestUrl();
        System.out.println("Test URL: " + testUrl);
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}