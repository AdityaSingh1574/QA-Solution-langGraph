package implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import static org.junit.Assert.assertTrue;
import HotelBookingLocators;

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

    public void enterDestination(String destination) {
        wait.until(ExpectedConditions.elementToBeClickable(HotelBookingLocators.DESTINATION_SEARCH_FIELD)).sendKeys(destination);
    }

    public void selectCheckInDate(String checkInDate) {
        wait.until(ExpectedConditions.elementToBeClickable(HotelBookingLocators.CHECKIN_DATE_BUTTON)).click();
        // Implement date selection logic here
    }

    public void selectCheckOutDate(String checkOutDate) {
        wait.until(ExpectedConditions.elementToBeClickable(HotelBookingLocators.CHECKOUT_DATE_BUTTON)).click();
        // Implement date selection logic here
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(HotelBookingLocators.SEARCH_BUTTON)).click();
    }

    public void verifySearchResultsPage() {
        assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(HotelBookingLocators.HOTEL_LIST)).isDisplayed());
    }

    public void viewHotelList() {
        // This step is implicit as the hotel list is already visible after search
    }

    public void selectTopHotel() {
        // As TOP_RESULT_HOTEL is null in the locators, we'll need to implement a custom logic to select the top hotel
        // For example, we could select the first hotel in the list
    }

    public void clickSeeAvailabilityButton() {
        wait.until(ExpectedConditions.elementToBeClickable(HotelBookingLocators.SEE_AVAILABILITY_BUTTON)).click();
    }

    public void verifyHotelAvailabilityPage() {
        // Implement logic to verify that we're on the hotel's availability page
        // This could involve checking for specific elements unique to the availability page
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}