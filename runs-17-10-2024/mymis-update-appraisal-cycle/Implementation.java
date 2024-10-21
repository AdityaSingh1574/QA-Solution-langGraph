package implementation;

import locators.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
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
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.usernameInput));
        usernameElement.sendKeys(userId);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.passwordInput));
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.loginButton));
        loginButtonElement.click();
    }

    public void verifyHomepageRedirect() {
        // Implement logic to verify homepage redirect
        // This could involve checking for a specific element on the homepage
    }

    public void navigateToAppraisalCycle() {
        WebElement appraisalCycleElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.appraisalCycleLink));
        appraisalCycleElement.click();
    }

    public void verifyAppraisalCyclePage() {
        // Implement logic to verify Appraisal Cycle page
        // This could involve checking for a specific element on the Appraisal Cycle page
    }

    public void selectAppraisalMonth(int year) {
        // Implement logic to select appraisal month
        // This might involve interacting with a dropdown or other selection mechanism
        // Note: The locator for this is not provided, so you may need to identify it
    }

    public void clickSaveButton() {
        // Implement logic to click save button
        // Note: The locator for this is not provided, so you may need to identify it
    }

    public void verifyUpdatedAppraisalCyclePage() {
        // Implement logic to verify updated Appraisal Cycle page
        // This could involve checking for a success message or updated information
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}