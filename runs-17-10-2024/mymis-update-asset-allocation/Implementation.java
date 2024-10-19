package implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import locators.Locators;
import org.openqa.selenium.By;
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

    public void navigateToAssetAllocation() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.assetAllocationSpan)).click();
    }

    public void selectManageAssets() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.manageAssetLink)).click();
    }

    public void verifyManageAssetsPage() {
        // Implement verification logic for Manage Assets page
        // This could be checking for a specific element or title
    }

    public void selectEditAsset() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.editAssetButton)).click();
    }

    public void changeAssetType(String assetType) {
        // Implement logic to change asset type
        // Note: The locator for assetTypeDropdown is null in the provided Locators class
    }

    public void changeSerialNumber(String serialNumber) {
        // Implement logic to change serial number
        // Note: The locator for serialNumberInput is null in the provided Locators class
    }

    public void clickUpdateAssetButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.updateAssetButton)).click();
    }

    public void verifyUpdatedAssetDetails() {
        // Implement verification logic for updated asset details
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}