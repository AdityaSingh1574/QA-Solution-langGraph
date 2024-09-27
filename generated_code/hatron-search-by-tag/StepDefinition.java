package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class StepDefinition {
    private Implementation implementation = new Implementation();
    private int initialCourseCount;

    @Given("user is on TestControl screen")
    public void userIsOnTestControlScreen() {
        implementation.launchUrl("https://your-testcontrol-url.com");
    }

    @When("enter search text {string} in Search by course-name")
    public void enterSearchTextInSearchByCourseName(String searchText) {
        implementation.enterSearchText(searchText);
    }

    @Then("verify if records are filtered by checking the count of courses")
    public void verifyIfRecordsAreFilteredByCheckingTheCountOfCourses() {
        int filteredCourseCount = implementation.getFilteredCourseCount();
        Assert.assertTrue("Filtered course count should be less than or equal to initial count", filteredCourseCount <= initialCourseCount);
    }

    @Then("the filtered results should only contain {string} courses")
    public void theFilteredResultsShouldOnlyContainCourses(String expectedCourse) {
        boolean allCoursesMatch = implementation.verifyFilteredResults(expectedCourse);
        Assert.assertTrue("All filtered courses should contain " + expectedCourse, allCoursesMatch);
        implementation.closeBrowser();
    }
}