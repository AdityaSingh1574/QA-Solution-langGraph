package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the AccuWeather homepage {string}")
    public void userIsOnAccuWeatherHomepage(String url) {
        implementation.launchUrl(url);
    }

    @When("User types {string} into the location input field")
    public void userTypesIntoLocationInputField(String location) {
        implementation.enterLocation(location);
    }

    @And("User presses enter")
    public void userPressesEnter() {
        implementation.pressEnter();
    }

    @Then("User should be redirected to the search results page")
    public void userShouldBeRedirectedToSearchResultsPage() {
        implementation.verifySearchResultsPage();
    }

    @When("User views the search results")
    public void userViewsSearchResults() {
        implementation.viewSearchResults();
    }

    @And("User selects the first option")
    public void userSelectsFirstOption() {
        implementation.selectFirstOption();
    }

    @Then("User should be redirected to the New Delhi weather page")
    public void userShouldBeRedirectedToNewDelhiWeatherPage() {
        implementation.verifyNewDelhiWeatherPage();
    }

    @And("User should see the current weather for New Delhi, India")
    public void userShouldSeeCurrentWeatherForNewDelhi() {
        implementation.verifyCurrentWeather();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}