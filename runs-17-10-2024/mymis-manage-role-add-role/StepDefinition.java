package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the login page {string}")
    public void userIsOnLoginPage(String url) {
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
        implementation.verifyHomepageRedirection();
    }

    @When("User navigates to the Manage Role page")
    public void userNavigatesToManageRolePage() {
        implementation.navigateToManageRolePage();
    }

    @And("User is redirected to the Manage Role page")
    public void userIsRedirectedToManageRolePage() {
        implementation.verifyManageRolePageRedirection();
    }

    @And("User enters the role name {string}")
    public void userEntersRoleName(String roleName) {
        implementation.enterRoleName(roleName);
    }

    @And("User clicks add role button")
    public void userClicksAddRoleButton() {
        implementation.clickAddRoleButton();
    }

    @Then("the new role should be added successfully")
    public void newRoleShouldBeAdded() {
        implementation.verifyRoleAdded();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}