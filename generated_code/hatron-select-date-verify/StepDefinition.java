package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinition {
    public Implementation implementation = new Implementation();

    @Given("user is on TestControl screen")
    public void userIsOnTestControlScreen() {
        implementation.launchUrl();
    }

    @When("user clicks on the start date selection button")
    public void userClicksOnStartDateSelectionButton() {
        implementation.clickStartDateButton();
    }

    @When("user selects the start date")
    public void userSelectsStartDate() {
        implementation.selectStartDate();
    }

    @When("user clicks on the end date selection button")
    public void userClicksOnEndDateSelectionButton() {
        implementation.clickEndDateButton();
    }

    @When("user selects the end date")
    public void userSelectsEndDate() {
        implementation.selectEndDate();
    }

    @Then("the system should filter the records based on the selected date range")
    public void systemFiltersRecords() {
        implementation.verifyFilteredRecords();
    }

    @Then("user should see only records within the specified date range")
    public void userSeesFilteredRecords() {
        implementation.verifyRecordsWithinDateRange();
    }

    @Then("the count of filtered records should be displayed")
    public void countOfFilteredRecordsDisplayed() {
        implementation.verifyRecordCount();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}