package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the login page {string}")
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

    @Then("User should be redirected to the dashboard")
    public void userRedirectedToDashboard() {
        implementation.verifyDashboardRedirection();
    }

    @Given("User is on the dashboard")
    public void userIsOnDashboard() {
        implementation.verifyDashboardPage();
    }

    @When("User navigates to test controls under tests")
    public void userNavigatesToTestControls() {
        implementation.navigateToTestControls();
    }

    @Then("User should be redirected to the test controls page")
    public void userRedirectedToTestControlsPage() {
        implementation.verifyTestControlsPage();
    }

    @When("User verifies if on HSC Examination screen")
    public void userVerifiesHSCExaminationScreen() {
        implementation.verifyHSCExaminationScreen();
    }

    @When("User navigates to Exam Template Management")
    public void userNavigatesToExamTemplateManagement() {
        implementation.navigateToExamTemplateManagement();
    }

    @Then("User should be redirected to the Exam Template Management screen")
    public void userRedirectedToExamTemplateManagementScreen() {
        implementation.verifyExamTemplateManagementScreen();
    }

    @Then("User verifies if on Exam Template Management screen")
    public void userVerifiesExamTemplateManagementScreen() {
        implementation.verifyExamTemplateManagementScreen();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}