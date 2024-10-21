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

    @Then("User should be redirected to the MyMIS homepage")
    public void userIsRedirectedToHomepage() {
        implementation.verifyHomepage();
    }

    @Given("User navigates to the Meal Management section")
    public void userNavigatesToMealManagement() {
        implementation.navigateToMealManagement();
    }

    @And("User clicks on the Meal Package option")
    public void userClicksMealPackageOption() {
        implementation.clickMealPackageOption();
    }

    @Then("User should be redirected to the Meal Package page")
    public void userIsRedirectedToMealPackagePage() {
        implementation.verifyMealPackagePage();
    }

    @When("User clicks on the 'Add new meal package' button")
    public void userClicksAddNewMealPackageButton() {
        implementation.clickAddNewMealPackageButton();
    }

    @And("User selects {string} from the meal period dropdown")
    public void userSelectsMealPeriod(String mealPeriod) {
        implementation.selectMealPeriod(mealPeriod);
    }

    @And("User selects {string} from the meal type dropdown")
    public void userSelectsMealType(String mealType) {
        implementation.selectMealType(mealType);
    }

    @And("User selects {string} from the meal category dropdown")
    public void userSelectsMealCategory(String mealCategory) {
        implementation.selectMealCategory(mealCategory);
    }

    @And("User clicks on the save button")
    public void userClicksSaveButton() {
        implementation.clickSaveButton();
    }

    @Then("User should be redirected to the Meal Package listing page")
    public void userIsRedirectedToMealPackageListingPage() {
        implementation.verifyMealPackageListingPage();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}