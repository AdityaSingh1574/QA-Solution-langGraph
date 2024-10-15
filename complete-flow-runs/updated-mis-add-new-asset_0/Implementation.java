package implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
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

    public void navigateToAssetAllocation() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.assetAllocationSpan)).click();
    }

    public void clickManageAssets() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.manageAssetLink)).click();
    }

    public void verifyAssetManagementPage() {
        wait.until(ExpectedConditions.urlContains("/Asset/Manage"));
    }

    public void clickAddNewAssetType() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.addNewAssetTypeButton)).click();
    }

    public void enterAssetType(String assetType) {
        if (!Locators.assetTypeInput.equals("NULL")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.assetTypeInput))).sendKeys(assetType);
        } else {
            System.out.println("Asset type input locator is NULL. Please provide a valid locator.");
        }
    }

    public void selectIsTemporary(String option) {
        if (!Locators.isTemporaryDropdown.equals("NULL")) {
            Select dropdown = new Select(driver.findElement(By.xpath(Locators.isTemporaryDropdown)));
            dropdown.selectByVisibleText(option);
        } else {
            System.out.println("Is temporary dropdown locator is NULL. Please provide a valid locator.");
        }
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.addButton)).click();
    }

    public void verifyAssetTypeAdded() {
        // Implement verification logic here
        // This could involve checking for a success message or verifying the new asset type in a list
        System.out.println("Asset type added successfully");
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}