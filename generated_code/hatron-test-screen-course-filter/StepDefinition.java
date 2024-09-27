package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("user is on TestControl screen")
    public void userIsOnTestControlScreen() {
        implementation.launchUrl("https://example.com/testcontrol"); // Replace with actual URL
        implementation.navigateToTestControlScreen();
    }

    @When("filter course values by clicking on the coures drop down and selecting {}")
    public void filterCourseValues(String course) {
        implementation.filterCourse(course);
    }

    @Then("verify if records are filtered based on total records by printing the records count in the counter")
    public void verifyRecordsFiltered() {
        String recordsCount = implementation.getRecordsCount();
        System.out.println("Filtered records count: " + recordsCount);
        // Add assertions here if needed
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}