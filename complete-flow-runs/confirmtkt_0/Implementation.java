package implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.List;
import org.junit.Assert;
import FlightSearchLocators;

public class Implementation {
    private WebDriver driver;
    private WebDriverWait wait;

    public void launchUrl(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickOnFromDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(FlightSearchLocators.FROM_DROPDOWN)).click();
    }

    public void selectFromCity(String city) {
        // Implement logic to select the city from the dropdown
        // This might involve searching for the city and clicking on it
    }

    public void clickOnToDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(FlightSearchLocators.TO_DROPDOWN)).click();
    }

    public void selectToCity(String city) {
        // Implement logic to select the city from the dropdown
        // This might involve searching for the city and clicking on it
    }

    public void selectDate(int day, String month, int year) {
        wait.until(ExpectedConditions.elementToBeClickable(FlightSearchLocators.DATE_PICKER)).click();
        // Implement logic to select the specific date from the date picker
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(FlightSearchLocators.SEARCH_BUTTON)).click();
    }

    public void verifySearchResultsPage() {
        // Implement logic to verify that the search results page has loaded
        // This might involve checking for the presence of certain elements specific to the results page
    }

    public void doubleClickDurationHeader() {
        WebElement durationHeader = wait.until(ExpectedConditions.elementToBeClickable(FlightSearchLocators.DURATION_COLUMN_HEADER));
        Actions actions = new Actions(driver);
        actions.doubleClick(durationHeader).perform();
    }

    public void verifySortedByDuration() {
        // Implement logic to verify that the results are sorted by duration
        // This might involve getting all duration elements and checking if they are in ascending order
    }

    public void verifySortedResultsPage() {
        // Implement logic to verify that the page shows sorted results
        // This might involve checking for any sorting indicators or comparing the order of results
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}