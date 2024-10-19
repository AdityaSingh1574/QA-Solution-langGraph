package implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.Locators;
import java.time.Duration;

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

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.usernameInput)).sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.passwordInput)).sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.loginButton)).click();
    }

    public void navigateToManageAssetAllocation() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.manageAssetLink)).click();
    }

    public void verifyAssetManagementPage() {
        // Add verification logic here
        // For example, check if a specific element on the asset management page is present
    }

    public void clickDeleteAssetButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.deleteAssetButton)).click();
    }

    public void confirmDeleteAsset() {
        // Note: The confirmDeleteButton locator is null in the provided Locators class
        // You may need to update the Locators class with the correct XPath for the confirm button
        if (Locators.confirmDeleteButton != null) {
            wait.until(ExpectedConditions.elementToBeClickable(Locators.confirmDeleteButton)).click();
        } else {
            System.out.println("Confirm delete button locator is not defined.");
        }
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}