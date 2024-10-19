package implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    public void enterUserId(String userId) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.usernameInput)).sendKeys(userId);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.passwordInput)).sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.loginButton)).click();
    }

    public void navigateToManagePolicy() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.managePoliciesLink)).click();
    }

    public void verifyMISHomepage() {
        // Add verification logic for MIS homepage
        // For example, check for a specific element on the homepage
    }

    public void clickViewPolicy() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.viewPolicyButton)).click();
    }

    public void clickDeactivatePolicy() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.deactivatePolicyButton)).click();
    }

    public void clickConfirmYes() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.confirmYesButton)).click();
    }

    public void clickDeletePolicy() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.deletePolicyButton)).click();
    }

    public void verifyManagePolicyPage() {
        // Add verification logic for Manage Policy page
        // For example, check for a specific element on the Manage Policy page
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}