package implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

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

    public void enterSearchTerm(String searchTerm) {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.SEARCH_INPUT));
        searchInput.sendKeys(searchTerm);
    }

    public void clickSearchButton() {
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.SEARCH_ICON_BUTTON));
        searchButton.click();
    }

    public void verifySearchResultsPage() {
        // Implement logic to verify search results page
        assertTrue("Search results page not loaded", driver.getCurrentUrl().contains("search"));
    }

    public void selectFirstBag() {
        // Implement logic to select the first bag from search results
        // This might involve finding and clicking on the first product in the results
    }

    public void verifyProductPage() {
        // Implement logic to verify product page
        assertTrue("Product page not loaded", driver.getCurrentUrl().contains("ip"));
    }

    public void clickAddToCartButton() {
        if (Locators.ADD_TO_CART_BUTTON != null) {
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.ADD_TO_CART_BUTTON));
            addToCartButton.click();
        } else {
            // Implement alternative logic if the locator is not available
        }
    }

    public void clickViewCartButton() {
        if (Locators.VIEW_CART_BUTTON != null) {
            WebElement viewCartButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.VIEW_CART_BUTTON));
            viewCartButton.click();
        } else {
            // Implement alternative logic if the locator is not available
        }
    }

    public void verifyCartConfirmationPage() {
        // Implement logic to verify cart confirmation page
        assertTrue("Cart confirmation page not loaded", driver.getCurrentUrl().contains("cart"));
    }

    public void verifyCartPage() {
        // Implement logic to verify cart page
        assertTrue("Cart page not loaded", driver.getCurrentUrl().contains("cart"));
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}