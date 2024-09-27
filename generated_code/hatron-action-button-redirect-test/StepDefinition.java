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
        // This step is already covered by the previous steps
    }

    @When("click on Actions")
    public void clickOnActions() {
        implementation.clickActionsButton();
    }

    @Then("verify if {string} exists in action menu by clicking on it")
    public void verifyActionMenuOption(String option) {
        assert implementation.verifyActionMenuOption(option) : option + " not found in action menu";
        implementation.clickActionMenuOption(option);
    }

    @And("verify if user is navigated to {string}")
    public void verifyNavigation(String destination) {
        assert implementation.verifyNavigation(destination) : "Navigation to " + destination + " failed";
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}