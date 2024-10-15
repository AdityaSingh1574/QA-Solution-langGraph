package implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import locators.Locators;
import org.openqa.selenium.support.ui.Select;
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

    public void enterUserId(String userId) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.usernameInput)).sendKeys(userId);
    }

    public void enterPassword(String password) {
        driver.findElement(Locators.passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(Locators.loginButton).click();
    }

    public void navigateToManageAssets() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.assetAllocationSpan)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Locators.manageAssetLink)).click();
    }

    public void verifyAssetManagementPage() {
        wait.until(ExpectedConditions.urlContains("/Asset/Manage"));
    }

    public void clickEditAssetButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.editAssetButton)).click();
    }

    public void changeAssetType(String assetType) {
        if (!Locators.assetTypeDropdown.equals("NULL")) {
            Select dropdown = new Select(driver.findElement(Locators.assetTypeDropdown));
            dropdown.selectByVisibleText(assetType);
        } else {
            System.out.println("Asset type dropdown locator is not available.");
        }
    }

    public void changeSerialNumber(String serialNumber) {
        if (!Locators.serialNumberInput.equals("NULL")) {
            driver.findElement(Locators.serialNumberInput).clear();
            driver.findElement(Locators.serialNumberInput).sendKeys(serialNumber);
        } else {
            System.out.println("Serial number input locator is not available.");
        }
    }

    public void clickUpdateAssetButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.updateAssetButton)).click();
    }

    public void verifyConfirmationPage() {
        // Implement verification logic for confirmation page
        // This could involve checking for a success message or a specific URL
        wait.until(ExpectedConditions.urlContains("/Asset/Confirmation"));
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}