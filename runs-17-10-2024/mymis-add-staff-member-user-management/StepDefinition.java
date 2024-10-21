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
    public void userIsRedirectedToHomepage() {
        implementation.verifyHomepage();
    }

    @Given("User navigates to the Manage Staff Member page")
    public void userNavigatesToManageStaffMemberPage() {
        implementation.navigateToManageStaffMember();
    }

    @When("User clicks on the {string} button")
    public void userClicksOnButton(String buttonText) {
        implementation.clickAddNewStaffMemberButton();
    }

    @And("User enters {string} in the name field")
    public void userEntersName(String name) {
        implementation.enterName(name);
    }

    @And("User enters {string} in the phone number field")
    public void userEntersPhoneNumber(String phoneNumber) {
        implementation.enterPhoneNumber(phoneNumber);
    }

    @And("User clicks on the location dropdown")
    public void userClicksLocationDropdown() {
        implementation.clickLocationDropdown();
    }

    @And("User selects {string} from the location dropdown")
    public void userSelectsLocation(String location) {
        implementation.selectLocation(location);
    }

    @And("User clicks on the save button")
    public void userClicksSaveButton() {
        implementation.clickSaveButton();
    }

    @Then("User should be redirected to the Manage Staff Member page")
    public void userIsRedirectedToManageStaffMemberPage() {
        implementation.verifyManageStaffMemberPage();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}