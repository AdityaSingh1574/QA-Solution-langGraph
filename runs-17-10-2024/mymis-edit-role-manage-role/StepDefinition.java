package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the MyMIS login page at {string}")
    public void userIsOnMyMISLoginPage(String url) {
        implementation.launchUrl(url);
    }

    @When("User types user id {string}")
    public void userTypesUserId(String userId) {
        implementation.enterUsername(userId);
    }

    @And("User types password {string}")
    public void userTypesPassword(String password) {
        implementation.enterPassword(password);
    }

    @And("User clicks login button")
    public void userClicksLoginButton() {
        implementation.clickLoginButton();
    }

    @Given("User navigates to manage role under Administrations")
    public void userNavigatesToManageRole() {
        implementation.navigateToManageRole();
    }

    @And("User is redirected to the MyMIS homepage")
    public void userIsRedirectedToHomepage() {
        implementation.verifyHomepage();
    }

    @When("User selects the role {string}")
    public void userSelectsRole(String roleName) {
        implementation.selectRole(roleName);
    }

    @And("User changes the name to {string}")
    public void userChangesRoleName(String newRoleName) {
        implementation.changeRoleName(newRoleName);
    }

    @And("User clicks update role button")
    public void userClicksUpdateRoleButton() {
        implementation.clickUpdateRoleButton();
    }

    @Then("User should be redirected to the Manage Role page")
    public void userIsRedirectedToManageRolePage() {
        implementation.verifyManageRolePage();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}