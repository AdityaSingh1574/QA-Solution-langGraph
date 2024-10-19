package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the MyMIS login page {string}")
    public void userIsOnTheMyMISLoginPage(String url) {
        implementation.launchUrl(url);
    }

    @When("User enters user id {string} in the username field")
    public void userEntersUserIdInTheUsernameField(String username) {
        implementation.enterUsername(username);
    }

    @And("User enters password {string} in the password field")
    public void userEntersPasswordInThePasswordField(String password) {
        implementation.enterPassword(password);
    }

    @And("User clicks on the login button")
    public void userClicksOnTheLoginButton() {
        implementation.clickLoginButton();
    }

    @Given("User navigates to the Manage Task Sub Details page")
    public void userNavigatesToTheManageTaskSubDetailsPage() {
        implementation.navigateToManageTaskSubDetails();
    }

    @And("User is redirected to the MyMIS homepage")
    public void userIsRedirectedToTheMyMISHomepage() {
        implementation.verifyHomepageRedirection();
    }

    @When("User clicks on the {string} button")
    public void userClicksOnTheButton(String buttonText) {
        implementation.clickAddNewTaskDetailsButton();
    }

    @And("User enters {string} in the task name input field")
    public void userEntersInTheTaskNameInputField(String taskName) {
        implementation.enterTaskName(taskName);
    }

    @And("User clicks on the add button")
    public void userClicksOnTheAddButton() {
        implementation.clickAddButton();
    }

    @Then("User should be redirected to the Manage Task Sub Detail page")
    public void userShouldBeRedirectedToTheManageTaskSubDetailPage() {
        implementation.verifyRedirectionToManageTaskSubDetailPage();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}