package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.junit.Assert;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("user is on TestControl screen")
    public void userIsOnTestControlScreen() {
        implementation.launchUrl("https://example.com/testcontrol"); // Replace with actual URL
    }

    @When("user clicks on Export test data button")
    public void userClicksOnExportTestDataButton() {
        implementation.clickExportTestDataButton();
    }

    @Then("the download button should appear")
    public void theDownloadButtonShouldAppear() {
        Assert.assertTrue("Download button is not visible", implementation.isDownloadButtonVisible());
    }

    @And("user should be able to click on the download button to export the test data")
    public void userShouldBeAbleToClickOnTheDownloadButtonToExportTheTestData() {
        implementation.clickDownloadButton();
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}