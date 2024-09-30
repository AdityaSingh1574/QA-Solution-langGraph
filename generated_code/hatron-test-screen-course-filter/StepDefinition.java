package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("User Selects Email option for login at {}")
    public void userSelectsEmailOptionForLogin(String url) {
        implementation.launchUrl(url);
        implementation.selectEmailLoginOption();
    }

    @And("User Types Email : {string}")
    public void userTypesEmail(String email) {
        implementation.enterEmail(email);
    }

    @And("User types password : {string} and clicks on Login button")
    public void userTypesPasswordAndClicksLogin(String password) {
        implementation.enterPasswordAndLogin(password);
    }

    @And("User clicks on the hanmburger button")
    public void userClicksHamburgerButton() {
        implementation.clickHamburgerButton();
    }

    @And("User Clicks on Tests dropdown")
    public void userClicksTestsDropdown() {
        implementation.clickTestsDropdown();
    }

    @And("user selects Test controls")
    public void userSelectsTestControls() {
        implementation.selectTestControls();
    }

    @Given("user is on TestControl screen")
    public void userIsOnTestControlScreen() {
        // This step is already covered by previous steps
    }

    @When("filter course values by clicking on the coures drop down and selecting {}")
    public void filterCourseValues(String course) {
        implementation.filterCourseBy(course);
    }

    @Then("verify if records are filtered based on total records by printing the records count in the counter")
    public void verifyRecordsFiltered() {
        String recordsCount = implementation.getRecordsCount();
        System.out.println("Filtered records count: " + recordsCount);
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}