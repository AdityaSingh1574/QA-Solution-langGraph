package implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import java.time.Duration;
import static org.junit.Assert.assertTrue;
import WeatherPageLocators;

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

    public void enterLocation(String location) {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(WeatherPageLocators.SEARCH_INPUT));
        searchInput.clear();
        searchInput.sendKeys(location);
    }

    public void pressEnter() {
        driver.findElement(WeatherPageLocators.SEARCH_INPUT).sendKeys(Keys.ENTER);
    }

    public void verifySearchResultsPage() {
        wait.until(ExpectedConditions.urlContains("search-results"));
    }

    public void viewSearchResults() {
        // This step is implicit as the results are already visible after the search
    }

    public void selectFirstOption() {
        WebElement firstOption = wait.until(ExpectedConditions.elementToBeClickable(WeatherPageLocators.TODAY_LINK));
        firstOption.click();
    }

    public void verifyNewDelhiWeatherPage() {
        wait.until(ExpectedConditions.urlContains("new-delhi"));
    }

    public void verifyCurrentWeather() {
        // This is a simplified check. You might want to add more specific verifications.
        assertTrue(driver.getPageSource().contains("New Delhi"));
        assertTrue(driver.getPageSource().contains("Current Weather"));
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}