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

    public void enterUsername(String username) {
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.usernameInput));
        usernameElement.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.passwordInput));
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.loginButton));
        loginButtonElement.click();
    }

    public void verifyHomepage() {
        // Implement logic to verify homepage
        // For example, check for a specific element on the homepage
    }

    public void navigateToAppraisalSection() {
        // Implement logic to navigate to appraisal section
        // This might involve clicking on a menu item or link
    }

    public void clickAppraisalCycle() {
        WebElement appraisalCycleElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.appraisalCycleLink));
        appraisalCycleElement.click();
    }

    public void verifyAppraisalCyclePage() {
        // Implement logic to verify Appraisal Cycle page
        // For example, check for a specific element on the Appraisal Cycle page
    }

    public void selectFirstAppraisalCycle() {
        // Implement logic to select the first appraisal cycle
        // This might involve clicking on a checkbox or radio button
    }

    public void clickDeleteButton() {
        WebElement deleteButtonElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.deleteFirstAppraisalCycleButton));
        deleteButtonElement.click();
    }

    public void confirmDeletion() {
        WebElement confirmDeletionElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.confirmDeletionButton));
        confirmDeletionElement.click();
    }

    public void verifyDeletion() {
        // Implement logic to verify that the first appraisal cycle has been deleted
        // This might involve checking that the element is no longer present or a success message is displayed
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}