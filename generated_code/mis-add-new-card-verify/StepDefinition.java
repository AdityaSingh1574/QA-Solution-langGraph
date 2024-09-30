package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("Login to MIS with Username {string} and password {string}")
    public void loginToMIS(String username, String password) {
        implementation.launchUrl("https://mymis.geminisolutions.com/");
        implementation.enterCredentials(username, password);
    }

    @When("Click on Signin button")
    public void clickOnSigninButton() {
        implementation.clickSignInButton();
    }

    @Then("User should be navigated to MIS homepage")
    public void verifyMISHomepage() {
        implementation.verifyMISHomepage();
    }

    @When("user navigates on {string} and then {string}")
    public void navigateToAccessCardManagement(String mainMenu, String subMenu) {
        implementation.navigateToAccessCardManagement();
    }

    @When("User adds new {string} Access card by clicking on the {string} button")
    public void clickAddNewCardButton(String cardNumber, String buttonText) {
        implementation.clickAddNewCardButton();
    }

    @When("User types the card number {string}")
    public void enterCardNumber(String cardNumber) {
        implementation.enterCardNumber(cardNumber);
    }

    @When("User toggles the temporary card option")
    public void toggleTemporaryCardOption() {
        implementation.toggleTemporaryCardOption();
    }

    @When("User clicks the Add button")
    public void clickAddButton() {
        implementation.clickAddButton();
    }

    @Then("Verify Card Added successfully")
    public void verifyCardAdded() {
        implementation.verifyCardAdded();
    }

    @Then("The new card {string} should appear in the list of access cards")
    public void verifyCardInList(String cardNumber) {
        implementation.verifyCardInList(cardNumber);
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}