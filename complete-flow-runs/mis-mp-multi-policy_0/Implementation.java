package implementation;

import org.openqa.selenium.WebDriver;
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.USERNAME_INPUT)).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(Locators.PASSWORD_INPUT).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(Locators.LOGIN_BUTTON).click();
    }

    public void verifyHomepage() {
        // Add logic to verify homepage
        assertTrue("Homepage not loaded", driver.getCurrentUrl().contains("home"));
    }

    public void navigateToManagePolicyPage() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.MANAGE_POLICIES_LINK)).click();
    }

    public void clickViewPolicy() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.VIEW_POLICY_BUTTON)).click();
    }

    public void clickDeactivatePolicy() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.DEACTIVATE_POLICY_BUTTON)).click();
    }

    public void confirmDeactivation() {
        // Add logic to confirm deactivation (e.g., clicking a confirmation button)
        // This step might require additional locators
    }

    public void clickDeletePolicy() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.DELETE_POLICY_BUTTON)).click();
    }

    public void confirmDeletion() {
        // Add logic to confirm deletion (e.g., clicking a confirmation button)
        // This step might require additional locators
    }

    public void verifyManagePolicyPage() {
        // Add logic to verify manage policy page
        assertTrue("Manage Policy page not loaded", driver.getCurrentUrl().contains("ManagePolicy"));
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}