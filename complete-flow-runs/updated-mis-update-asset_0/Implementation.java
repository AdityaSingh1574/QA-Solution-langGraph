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
        driver.findElement(Locators.passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(Locators.loginButton).click();
    }

    public void navigateToManageAssetAllocation() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.manageLink)).click();
    }

    public void verifyAssetManagementPage() {
        wait.until(ExpectedConditions.urlContains("/Asset/Manage"));
    }

    public void clickDeleteAsset() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.deleteAssetButton)).click();
    }

    public void confirmDeleteAsset() {
        // Note: The confirmDeleteButton locator is null in the provided Locators class.
        // You may need to update this with the correct locator when available.
        if (Locators.confirmDeleteButton != null) {
            wait.until(ExpectedConditions.elementToBeClickable(Locators.confirmDeleteButton)).click();
        } else {
            System.out.println("Confirm delete button locator is not available. Please update the Locators class.");
        }
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}