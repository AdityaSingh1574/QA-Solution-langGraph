package implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import Locators.*;

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.USERNAME_INPUT)).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(LoginPageLocators.PASSWORD_INPUT).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(LoginPageLocators.LOGIN_BUTTON).click();
    }

    public void navigateToManageAssets() {
        wait.until(ExpectedConditions.elementToBeClickable(AssetManagementLocators.ASSET_ALLOCATION_SPAN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(AssetManagementLocators.MANAGE_ASSET_LINK)).click();
    }

    public void verifyHomepageRedirect() {
        // Implement logic to verify homepage redirect
        // This might involve checking for a specific element on the homepage
    }

    public void clickAddNewAssetTypeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(AssetManagementLocators.ADD_NEW_ASSET_TYPE_BUTTON)).click();
    }

    public void enterAssetType(String assetType) {
        // Implement logic to enter asset type
        // Note: The XPath for this element was not provided in the locators
    }

    public void selectIsTemporaryOption(String option) {
        // Implement logic to select Is temporary option
        // Note: The XPath for this element was not provided in the locators
    }

    public void clickAddButton() {
        driver.findElement(AssetManagementLocators.ADD_BUTTON).click();
    }

    public void verifyAssetManagementPageRedirect() {
        // Implement logic to verify redirect to Asset Management page
        // This might involve checking for a specific element on the Asset Management page
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}