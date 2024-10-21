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

    @Then("User should be redirected to the MIS homepage")
    public void userRedirectedToHomepage() {
        implementation.verifyHomepage();
    }

    @Given("User navigates to the User Role section under Administrations")
    public void userNavigatesToUserRoleSection() {
        implementation.navigateToUserRoleSection();
    }

    @And("User should be redirected to the User Role page")
    public void userRedirectedToUserRolePage() {
        implementation.verifyUserRolePage();
    }

    @When("User selects the user {string} to edit")
    public void userSelectsUserToEdit(String username) {
        implementation.selectUserToEdit(username);
    }

    @And("User selects {string} from the role dropdown")
    public void userSelectsRole(String role) {
        implementation.selectRole(role);
    }

    @And("User clicks on the update button")
    public void userClicksUpdateButton() {
        implementation.clickUpdateButton();
    }

    @Then("The user role should be updated successfully")
    public void userRoleUpdatedSuccessfully() {
        implementation.verifyRoleUpdate();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}