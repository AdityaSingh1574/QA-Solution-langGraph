package stepdefinitions;

import implementations.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the login page")
    public void userIsOnLoginPage() {
        implementation.launchUrl("https://mymis.geminisolutions.com");
    }

    @When("User enters user id {string} in the username field")
    public void userEntersUsername(String username) {
        implementation.enterUsername(username);
    }

    @When("User enters password {string} in the password field")
    public void userEntersPassword(String password) {
        implementation.enterPassword(password);
    }

    @When("User clicks on the login button")
    public void userClicksLoginButton() {
        implementation.clickLoginButton();
    }

    @Then("User should be redirected to the homepage")
    public void userIsRedirectedToHomepage() {
        // Implement verification logic if needed
    }

    @Given("User is on the homepage")
    public void userIsOnHomepage() {
        // Implement verification logic if needed
    }

    @When("User navigates to 'Access Card Management'")
    public void userNavigatesToAccessCardManagement() {
        implementation.navigateToAccessCardManagement();
    }

    @When("User clicks on 'Manage Access Card'")
    public void userClicksOnManageAccessCard() {
        implementation.clickManageAccessCard();
    }

    @Then("User should be redirected to the Access Card Management page")
    public void userIsRedirectedToAccessCardManagementPage() {
        Assert.assertTrue("User is not on Access Card Management page", implementation.isOnAccessCardManagementPage());
    }

    @When("User selects {string} from the record selection dropdown")
    public void userSelectsRecordsPerPage(String number) {
        implementation.selectRecordsPerPage(number);
    }

    @When("User clicks on the 'Next' button")
    public void userClicksNextButton() {
        implementation.clickNextButton();
    }

    @When("User clicks on the 'Previous' button")
    public void userClicksPreviousButton() {
        implementation.clickPreviousButton();
    }

    @Then("User should remain on the Access Card Management page")
    public void userRemainsOnAccessCardManagementPage() {
        Assert.assertTrue("User is not on Access Card Management page", implementation.isOnAccessCardManagementPage());
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}