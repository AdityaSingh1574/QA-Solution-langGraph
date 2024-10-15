package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User is on the Booking.com homepage")
    public void userIsOnBookingHomepage() {
        implementation.launchUrl("https://www.booking.com");
    }

    @When("User enters {string} into the destination search field")
    public void userEntersDestination(String destination) {
        implementation.enterDestination(destination);
    }

    @When("User selects check-in date {string}")
    public void userSelectsCheckInDate(String checkInDate) {
        implementation.selectCheckInDate(checkInDate);
    }

    @When("User selects check-out date {string}")
    public void userSelectsCheckOutDate(String checkOutDate) {
        implementation.selectCheckOutDate(checkOutDate);
    }

    @When("User clicks the search button")
    public void userClicksSearchButton() {
        implementation.clickSearchButton();
    }

    @Then("User should be redirected to the search results page")
    public void userIsRedirectedToSearchResults() {
        implementation.verifySearchResultsPage();
    }

    @When("User views the list of available hotels")
    public void userViewsHotelList() {
        implementation.viewHotelList();
    }

    @When("User selects the top result hotel")
    public void userSelectsTopHotel() {
        implementation.selectTopHotel();
    }

    @When("User clicks the 'see availability' button")
    public void userClicksSeeAvailabilityButton() {
        implementation.clickSeeAvailabilityButton();
    }

    @Then("User should be redirected to the hotel's availability page")
    public void userIsRedirectedToHotelAvailabilityPage() {
        implementation.verifyHotelAvailabilityPage();
    }
}