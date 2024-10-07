package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the ConfirmTkt homepage")
    public void userIsOnConfirmTktHomepage() {
        implementation.launchUrl("https://www.confirmtkt.com");
    }

    @When("User clicks on 'From' dropdown")
    public void userClicksOnFromDropdown() {
        implementation.clickOnFromDropdown();
    }

    @And("User selects 'New Delhi' from the dropdown")
    public void userSelectsNewDelhiFromDropdown() {
        implementation.selectFromCity("New Delhi");
    }

    @And("User clicks on 'To' dropdown")
    public void userClicksOnToDropdown() {
        implementation.clickOnToDropdown();
    }

    @And("User selects 'Mumbai Central' from the dropdown")
    public void userSelectsMumbaiCentralFromDropdown() {
        implementation.selectToCity("Mumbai Central");
    }

    @And("User selects date '{int} October {int}' from date picker")
    public void userSelectsDateFromDatePicker(int day, int year) {
        implementation.selectDate(day, "October", year);
    }

    @And("User clicks on search button")
    public void userClicksOnSearchButton() {
        implementation.clickSearchButton();
    }

    @Then("User should be redirected to the search results page")
    public void userShouldBeRedirectedToSearchResultsPage() {
        implementation.verifySearchResultsPage();
    }

    @When("User double clicks on 'Duration' column header")
    public void userDoubleClicksOnDurationColumnHeader() {
        implementation.doubleClickDurationHeader();
    }

    @Then("Results should be sorted by travel time in ascending order")
    public void resultsShouldBeSortedByTravelTimeAscending() {
        implementation.verifySortedByDuration();
    }

    @And("User should be redirected to the sorted results page")
    public void userShouldBeRedirectedToSortedResultsPage() {
        implementation.verifySortedResultsPage();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}