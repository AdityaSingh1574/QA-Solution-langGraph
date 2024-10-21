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

    @Then("User should be redirected to the MyMIS homepage")
    public void userShouldBeRedirectedToTheMyMISHomepage() {
        implementation.verifyHomepage();
    }

    @Given("User navigates to Manage Menu under Administrations")
    public void userNavigatesToManageMenuUnderAdministrations() {
        implementation.navigateToManageMenu();
    }

    @And("User is redirected to the Manage Menu page")
    public void userIsRedirectedToTheManageMenuPage() {
        implementation.verifyManageMenuPage();
    }

    @When("User clicks on 'Add new navigation menu' button")
    public void userClicksOnAddNewNavigationMenuButton() {
        implementation.clickAddNewNavigationMenuButton();
    }

    @And("User enters {string} as the menu name")
    public void userEntersAsTheMenuName(String menuName) {
        implementation.enterMenuName(menuName);
    }

    @And("User enters the action name")
    public void userEntersTheActionName() {
        implementation.enterActionName();
    }

    @And("User enters the controller name")
    public void userEntersTheControllerName() {
        implementation.enterControllerName();
    }

    @And("User enters the css class")
    public void userEntersTheCssClass() {
        implementation.enterCssClass();
    }

    @And("User enters the menu sequence")
    public void userEntersTheMenuSequence() {
        implementation.enterMenuSequence();
    }

    @And("User toggles select menu")
    public void userTogglesSelectMenu() {
        implementation.toggleSelectMenu();
    }

    @And("User selects 'is link enabled' as true")
    public void userSelectsIsLinkEnabledAsTrue() {
        implementation.selectIsLinkEnabled();
    }

    @And("User selects 'is delegatable' as true")
    public void userSelectsIsDelegatableAsTrue() {
        implementation.selectIsDelegatable();
    }

    @And("User clicks on 'Add navigation menu' button")
    public void userClicksOnAddNavigationMenuButton() {
        implementation.clickAddNavigationMenuButton();
    }

    @Then("User should be redirected to the Manage Menu page")
    public void userShouldBeRedirectedToTheManageMenuPage() {
        implementation.verifyRedirectionToManageMenuPage();
    }
}