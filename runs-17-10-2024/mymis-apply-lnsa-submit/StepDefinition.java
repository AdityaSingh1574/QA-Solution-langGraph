package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("user is on the MyMIS login page {string}")
    public void userIsOnTheMyMISLoginPage(String url) {
        implementation.launchUrl(url);
    }

    @When("user enters user id {string} in the username field")
    public void userEntersUserIdInTheUsernameField(String username) {
        implementation.enterUsername(username);
    }

    @When("user enters password {string} in the password field")
    public void userEntersPasswordInThePasswordField(String password) {
        implementation.enterPassword(password);
    }

    @When("user clicks on the login button")
    public void userClicksOnTheLoginButton() {
        implementation.clickLoginButton();
    }

    @Then("user should be redirected to the MyMIS homepage")
    public void userShouldBeRedirectedToTheMyMISHomepage() {
        implementation.verifyHomepage();
    }

    @Given("user is on the MyMIS homepage")
    public void userIsOnTheMyMISHomepage() {
        implementation.verifyHomepage();
    }

    @When("user navigates to the LNSA Apply page")
    public void userNavigatesToTheLNSAApplyPage() {
        implementation.navigateToLNSAApplyPage();
    }

    @Then("user should be redirected to the LNSA Apply page")
    public void userShouldBeRedirectedToTheLNSAApplyPage() {
        implementation.verifyLNSAApplyPage();
    }

    @When("user checks the checkbox for Week {int}")
    public void userChecksTheCheckboxForWeek(int weekNumber) {
        implementation.checkWeekCheckbox(weekNumber);
    }

    @When("user clicks on the submit button")
    public void userClicksOnTheSubmitButton() {
        implementation.clickSubmitButton();
    }

    @When("user enters {string} as the reason in the input field")
    public void userEntersReasonInTheInputField(String reason) {
        implementation.enterReason(reason);
    }

    @When("user clicks on the final submit button")
    public void userClicksOnTheFinalSubmitButton() {
        implementation.clickFinalSubmitButton();
    }

    @Then("the LNSA application should be submitted successfully")
    public void theLNSAApplicationShouldBeSubmittedSuccessfully() {
        implementation.verifyLNSASubmission();
    }
}