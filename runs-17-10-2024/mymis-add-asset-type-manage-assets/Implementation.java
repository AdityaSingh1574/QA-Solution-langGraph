package implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import locators.Locators;

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

    public void verifyHomepage() {
        // Implement logic to verify homepage
        // For example, check for a specific element on the homepage
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.assetAllocationSpan));
    }

    public void navigateToMenu(String menuName) {
        if (menuName.equals("Asset Allocation")) {
            wait.until(ExpectedConditions.elementToBeClickable(Locators.assetAllocationSpan)).click();
        }
    }

    public void clickOnOption(String option) {
        if (option.equals("Manage Assets")) {
            wait.until(ExpectedConditions.elementToBeClickable(Locators.manageAssetLink)).click();
        }
    }

    public void verifyManageAssetsPage() {
        // Implement logic to verify Manage Assets page
        // For example, check for a specific element on the Manage Assets page
        wait.until(ExpectedConditions.urlContains("Asset/Manage"));
    }

    public void clickOnButton(String buttonName) {
        if (buttonName.equals("Add new asset type")) {
            wait.until(ExpectedConditions.elementToBeClickable(Locators.addNewAssetTypeButton)).click();
        } else if (buttonName.equals("Add")) {
            wait.until(ExpectedConditions.elementToBeClickable(Locators.addButton)).click();
        }
    }

    public void enterAssetType(String assetType) {
        if (!Locators.assetTypeInput.equals("NULL")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.assetTypeInput))).sendKeys(assetType);
        } else {
            // Handle the case when the locator is not available
            System.out.println("Asset type input locator is not available");
        }
    }

    public void selectFromDropdown(String dropdownName, String value) {
        if (dropdownName.equals("Is temporary") && !Locators.isTemporaryDropdown.equals("NULL")) {
            Select dropdown = new Select(driver.findElement(By.xpath(Locators.isTemporaryDropdown)));
            dropdown.selectByVisibleText(value);
        } else {
            // Handle the case when the locator is not available
            System.out.println("Dropdown locator is not available");
        }
    }

    public void verifyAssetTypeAdded() {
        // Implement logic to verify asset type added successfully
        // For example, check for a success message or the presence of the new asset type in a list
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}