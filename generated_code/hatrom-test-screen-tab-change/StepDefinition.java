package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
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

    @When("User types Email {string}")
    public void userTypesEmail(String email) {
        implementation.enterEmail(email);
    }

    @When("User types password {string}")
    public void userTypesPassword(String password) {
        implementation.enterPassword(password);
    }

    @When("User clicks on Login button")
    public void userClicksLoginButton() {
        implementation.clickLoginButton();
    }

    @When("User clicks on the hamburger button")
    public void userClicksHamburgerButton() {
        implementation.clickHamburgerButton();
    }

    @When("User clicks on Tests dropdown")
    public void userClicksTestsDropdown() {
        implementation.clickTestsDropdown();
    }

    @When("User selects Test controls")
    public void userSelectsTestControls() {
        implementation.selectTestControls();
    }

    @Given("user is on TestControl screen")
    public void userIsOnTestControlScreen() {
        // This step is implicitly verified by the previous steps
    }

    @Then("Verify if user is on HSC Examination screen")
    public void verifyUserIsOnHSCExaminationScreen() {
        Assert.assertTrue("User is not on HSC Examination screen", implementation.isOnHSCExaminationScreen());
    }

    @When("user navigates to Exam Template Management")
    public void userNavigatesToExamTemplateManagement() {
        implementation.navigateToExamTemplateManagement();
    }

    @Then("Verify if user is on Exam Template Management screen")
    public void verifyUserIsOnExamTemplateManagementScreen() {
        Assert.assertTrue("User is not on Exam Template Management screen", implementation.isOnExamTemplateManagementScreen());
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}