package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the MyMIS login page {string}")
    public void userIsOnMyMISLoginPage(String url) {
        implementation.launchUrl(url);
    }

    @When("User enters user id {string} in the username field")
    public void userEntersUsername(String username) {
        implementation.enterUsername(username);
    }

    @And("User enters password {string} in the password field")
    public void userEntersPassword(String password) {
        implementation.enterPassword(password);
    }

    @And("User clicks on the login button")
    public void userClicksLoginButton() {
        implementation.clickLoginButton();
    }

    @Given("User is redirected to the MyMIS homepage")
    public void userIsRedirectedToHomepage() {
        implementation.verifyHomepage();
    }

    @When("User navigates to the appraisal section")
    public void userNavigatesToAppraisalSection() {
        implementation.navigateToAppraisalSection();
    }

    @And("User clicks on appraisal cycle")
    public void userClicksOnAppraisalCycle() {
        implementation.clickAppraisalCycle();
    }

    @Then("User is redirected to the Appraisal Cycle page")
    public void userIsRedirectedToAppraisalCyclePage() {
        implementation.verifyAppraisalCyclePage();
    }

    @When("User selects the first appraisal cycle")
    public void userSelectsFirstAppraisalCycle() {
        implementation.selectFirstAppraisalCycle();
    }

    @And("User clicks on the delete button")
    public void userClicksDeleteButton() {
        implementation.clickDeleteButton();
    }

    @And("User confirms the deletion")
    public void userConfirmsDeletion() {
        implementation.confirmDeletion();
    }

    @Then("The first appraisal cycle should be deleted")
    public void firstAppraisalCycleShouldBeDeleted() {
        implementation.verifyDeletion();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}