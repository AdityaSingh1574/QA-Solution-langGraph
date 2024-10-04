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

    public void enterUsername(String username) {
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.USERNAME_INPUT[0]));
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.PASSWORD_INPUT[0]));
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.LOGIN_BUTTON[0]));
        loginButton.click();
    }

    public void verifyLogin() {
        // Add verification logic here
        // For example, check if a dashboard element is present
        assertTrue("Login failed", driver.getTitle().contains("Dashboard"));
    }

    public void navigateToSection(String section) {
        if (section.equals("Asset Allocation")) {
            WebElement assetAllocationSpan = wait.until(ExpectedConditions.elementToBeClickable(Locators.ASSET_ALLOCATION_SPAN[0]));
            assetAllocationSpan.click();
        }
    }

    public void clickOnLink(String link) {
        if (link.equals("Manage Assets")) {
            WebElement manageAssetLink = wait.until(ExpectedConditions.elementToBeClickable(Locators.MANAGE_ASSET_LINK[0]));
            manageAssetLink.click();
        }
    }

    public void verifyAssetManagementPage() {
        // Add verification logic here
        assertTrue("Not on Asset Management page", driver.getCurrentUrl().contains("/Asset/Manage"));
    }

    public void clickOnButton(String buttonName) {
        if (buttonName.equals("Edit Asset")) {
            WebElement editAssetButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.EDIT_ASSET_BUTTON[0]));
            editAssetButton.click();
        }
    }

    public void changeAssetType(String assetType) {
        // Implementation pending due to missing locator
        // WebElement assetTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(Locators.ASSET_TYPE_DROPDOWN[0]));
        // Select select = new Select(assetTypeDropdown);
        // select.selectByVisibleText(assetType);
    }

    public void updateSerialNumber(String serialNumber) {
        // Implementation pending due to missing locator
        // WebElement serialNumberInput = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.SERIAL_NUMBER_INPUT[0]));
        // serialNumberInput.clear();
        // serialNumberInput.sendKeys(serialNumber);
    }

    public void clickUpdateButton() {
        // Implementation pending due to missing locator
        // WebElement updateButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.UPDATE_BUTTON[0]));
        // updateButton.click();
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}