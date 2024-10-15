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

    public void verifyHomepage() {
        wait.until(ExpectedConditions.urlContains("mymis.geminisolutions.com"));
    }

    public void navigateToManageAssetsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.assetAllocationSpan)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Locators.manageAssetLink)).click();
    }

    public void clickAddNewAssetTypeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.addNewAssetTypeButton)).click();
    }

    public void enterAssetType(String assetType) {
        // Note: The XPath for assetTypeInput is not provided in the locators, so this is a placeholder
        // You may need to update this once you have the correct locator
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.assetTypeInput)).sendKeys(assetType);
    }

    public void selectIsTemporaryOption(String option) {
        // Note: The XPath for isTemporaryDropdown is not provided in the locators, so this is a placeholder
        // You may need to update this once you have the correct locator
        // This is a simplified version, you might need to implement a proper dropdown selection
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.isTemporaryDropdown)).sendKeys(option);
    }

    public void clickAddButton() {
        driver.findElement(Locators.addButton).click();
    }

    public void verifyAssetManagementPage() {
        wait.until(ExpectedConditions.urlContains("Asset/Manage"));
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}