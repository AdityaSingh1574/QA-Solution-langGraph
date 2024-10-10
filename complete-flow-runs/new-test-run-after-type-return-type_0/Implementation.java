package implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;

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

    public void navigateToAssetAllocation() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.assetAllocationSpan)).click();
    }

    public void clickManageAssets() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.manageAssetLink)).click();
    }

    public void verifyAssetManagementPage() {
        wait.until(ExpectedConditions.urlContains("Asset/Manage"));
    }

    public void clickAddNewAssetTypeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.addNewAssetTypeButton)).click();
    }

    public void enterAssetType(String assetType) {
        // Assuming there's an input field for asset type, we'll use a generic XPath
        By assetTypeInput = By.xpath("//input[@placeholder='Enter Asset Type']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(assetTypeInput)).sendKeys(assetType);
    }

    public void selectIsTemporaryOption(String option) {
        // Assuming there's a dropdown for Is temporary option, we'll use a generic XPath
        By isTemporaryDropdown = By.xpath("//select[@name='IsTemporary']");
        Select dropdown = new Select(driver.findElement(isTemporaryDropdown));
        dropdown.selectByVisibleText(option);
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.addButton)).click();
    }

    public void verifyAssetTypeAdded() {
        // Assuming there's a success message or the new asset type appears in a list
        // We'll use a generic XPath to check for a success message
        By successMessage = By.xpath("//div[contains(text(),'Asset type added successfully')]");
        Assert.assertTrue("Asset type was not added successfully", 
            wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed());
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}