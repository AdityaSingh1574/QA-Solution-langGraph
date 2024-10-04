package implementations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import FlipkartLocators;

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(FlipkartLocators.SEARCH_INPUT)).sendKeys(searchTerm);
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(FlipkartLocators.SEARCH_BUTTON)).click();
    }

    public void selectFirstChair() {
        wait.until(ExpectedConditions.elementToBeClickable(FlipkartLocators.FIRST_CHAIR_LINK)).click();
    }

    public void clickAddToCartButton() {
        // Note: ADD_TO_CART_BUTTON locator is not provided, so this is a placeholder
        // You should replace this with the correct locator when available
        wait.until(ExpectedConditions.elementToBeClickable(FlipkartLocators.ADD_TO_CART_BUTTON)).click();
    }

    public void clickPlaceOrderButton() {
        // Note: PLACE_ORDER_BUTTON locator is not provided, so this is a placeholder
        // You should replace this with the correct locator when available
        wait.until(ExpectedConditions.elementToBeClickable(FlipkartLocators.PLACE_ORDER_BUTTON)).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}