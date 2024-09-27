package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("user is on TestControl screen at {}")
    public void userIsOnTestControlScreen(String url) {
        implementation.launchUrl(url);
    }

    @When("the page loads completely")
    public void pageLoadsCompletely() {
        // The page load is implicitly waited for in the launchUrl method
    }

    @Then("the user should see the HSC Examination screen")
    public void userShouldSeeHSCExaminationScreen() {
        implementation.verifyHSCExaminationScreen();
    }

    @When("the user navigates to Exam Template Management")
    public void userNavigatesToExamTemplateManagement() {
        implementation.navigateToExamTemplateManagement();
    }

    @Then("the user should be on the Exam Template Management screen")
    public void userShouldBeOnExamTemplateManagementScreen() {
        implementation.verifyExamTemplateManagementScreen();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}