package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the MIS login page {string}")
    public void userIsOnMISLoginPage(String url) {
        implementation.launchUrl(url);
    }

    @When("User enters user id {string}")
    public void userEntersUserId(String userId) {
        implementation.enterUserId(userId);
    }

    @And("User enters password {string}")
    public void userEntersPassword(String password) {
        implementation.enterPassword(password);
    }

    @And("User clicks on the login button")
    public void userClicksOnLoginButton() {
        implementation.clickLoginButton();
    }

    @Then("User should be redirected to the MIS homepage")
    public void userShouldBeRedirectedToMISHomepage() {
        implementation.verifyHomepage();
    }

    @Given("User navigates to Parameter Master under Appraisal")
    public void userNavigatesToParameterMaster() {
        implementation.navigateToParameterMaster();
    }

    @Then("User should be redirected to the Parameter Master page")
    public void userShouldBeRedirectedToParameterMasterPage() {
        implementation.verifyParameterMasterPage();
    }

    @When("User clicks on the competency dropdown")
    public void userClicksOnCompetencyDropdown() {
        implementation.clickCompetencyDropdown();
    }

    @And("User selects {string} from the competency dropdown")
    public void userSelectsFromCompetencyDropdown(String option) {
        implementation.selectCompetencyOption(option);
    }

    @And("User enters {string} in the parameter name field")
    public void userEntersParameterName(String parameterName) {
        implementation.enterParameterName(parameterName);
    }

    @And("User clicks on the weightage dropdown")
    public void userClicksOnWeightageDropdown() {
        implementation.clickWeightageDropdown();
    }

    @And("User selects {string} from the weightage dropdown")
    public void userSelectsFromWeightageDropdown(String option) {
        implementation.selectWeightageOption(option);
    }

    @And("User clicks on the Add button")
    public void userClicksOnAddButton() {
        implementation.clickAddButton();
    }

    @Then("the new parameter should be added to the Parameter Master")
    public void newParameterShouldBeAdded() {
        implementation.verifyParameterAdded();
    }
}