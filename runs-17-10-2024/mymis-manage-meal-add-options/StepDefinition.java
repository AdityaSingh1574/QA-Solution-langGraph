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

    @Then("User should be redirected to the dashboard")
    public void userShouldBeRedirectedToDashboard() {
        implementation.verifyDashboardRedirection();
    }

    @Given("User navigates to manage under meal management")
    public void userNavigatesToManageUnderMealManagement() {
        implementation.navigateToMealManagement();
    }

    @And("User is redirected to the meal management page")
    public void userIsRedirectedToMealManagementPage() {
        implementation.verifyMealManagementPage();
    }

    @When("User clicks 'Add Meal Period' button")
    public void userClicksAddMealPeriodButton() {
        implementation.clickAddMealPeriodButton();
    }

    @And("User enters {string} in the meal period input field")
    public void userEntersMealPeriod(String mealPeriod) {
        implementation.enterMealPeriod(mealPeriod);
    }

    @And("User clicks save button under meal period tab")
    public void userClicksSaveMealPeriodButton() {
        implementation.clickSaveMealPeriodButton();
    }

    @And("User clicks 'Add Meal Type' button")
    public void userClicksAddMealTypeButton() {
        implementation.clickAddMealTypeButton();
    }

    @And("User enters {string} in the meal type input field")
    public void userEntersMealType(String mealType) {
        implementation.enterMealType(mealType);
    }

    @And("User clicks save button under meal type tab")
    public void userClicksSaveMealTypeButton() {
        implementation.clickSaveMealTypeButton();
    }

    @And("User clicks 'Add Meal Category' button")
    public void userClicksAddMealCategoryButton() {
        implementation.clickAddMealCategoryButton();
    }

    @And("User enters {string} in the meal category input field")
    public void userEntersMealCategory(String mealCategory) {
        implementation.enterMealCategory(mealCategory);
    }

    @And("User clicks save button under meal category tab")
    public void userClicksSaveMealCategoryButton() {
        implementation.clickSaveMealCategoryButton();
    }

    @And("User clicks 'Add Meal Dishes' button")
    public void userClicksAddMealDishesButton() {
        implementation.clickAddMealDishesButton();
    }

    @And("User enters {string} in the meal dishes input field")
    public void userEntersMealDishes(String mealDishes) {
        implementation.enterMealDishes(mealDishes);
    }

    @And("User clicks save button under meal dishes tab")
    public void userClicksSaveMealDishesButton() {
        implementation.clickSaveMealDishesButton();
    }

    @Then("User should be redirected to the meal management page")
    public void userShouldBeRedirectedToMealManagementPage() {
        implementation.verifyMealManagementPageRedirection();
    }
}