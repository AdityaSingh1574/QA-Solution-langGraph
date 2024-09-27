package stepdefinitions;

import implementation.Implementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class StepDefinition {
    private Implementation implementation = new Implementation();

    @Given("user is on Groww's SIP calculator webpage")
    public void userIsOnGrowwSIPCalculatorWebpage() {
        implementation.launchUrl("https://groww.in/calculators/sip-calculator");
    }

    @When("the user enters {string} into the {string} field")
    public void userEntersValueIntoField(String value, String field) {
        switch (field) {
            case "Monthly investment":
                implementation.enterMonthlyInvestment(value);
                break;
            case "Time period":
                implementation.enterTimePeriod(value);
                break;
            case "Expected return rate (p.a)":
                implementation.enterExpectedReturnRate(value);
                break;
            default:
                throw new IllegalArgumentException("Invalid field: " + field);
        }
    }

    @Then("the future values such as Investment amount, Est. returns, and Total value of the investment are displayed")
    public void futureValuesAreDisplayed() {
        Assert.assertTrue("Future values are not displayed", implementation.areFutureValuesDisplayed());
    }

    @Then("close the browser")
    public void closeBrowser() {
        implementation.closeBrowser();
    }
}