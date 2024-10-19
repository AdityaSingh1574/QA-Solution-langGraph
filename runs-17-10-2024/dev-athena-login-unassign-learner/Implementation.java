package implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import locators.Locators;

public class Implementation {
    private WebDriver driver;
    private WebDriverWait wait;
    private int initialLearnersCount;

    public void launchUrl() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://dev-athena.geminisolutions.com");
    }

    public void enterEmail(String email) {
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.emailInput));
        emailElement.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.passwordInput));
        passwordElement.sendKeys(password);
    }

    public void clickSignInButton() {
        WebElement signInElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.signInButton));
        signInElement.click();
    }

    public void verifyDashboardRedirect() {
        // Implement dashboard verification logic
    }

    public void selectManageCourses() {
        WebElement manageCourseElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.manageCourses));
        manageCourseElement.click();
    }

    public void selectBatches() {
        WebElement batchesElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.batches));
        batchesElement.click();
    }

    public void verifyBatchesPageRedirect() {
        // Implement batches page verification logic
    }

    public void clickActionsIcon() {
        if (Locators.actionsIcon != null) {
            WebElement actionsIconElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.actionsIcon));
            actionsIconElement.click();
        }
    }

    public void selectAssignLearners() {
        if (Locators.assignLearnersOption != null) {
            WebElement assignLearnersElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.assignLearnersOption));
            assignLearnersElement.click();
        }
    }

    public void verifyAssignLearnersPageRedirect() {
        // Implement assign learners page verification logic
    }

    public void getCurrentAssignedLearnersCount() {
        WebElement countElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.assignedLearnersCount));
        initialLearnersCount = Integer.parseInt(countElement.getText());
    }

    public void unassignLearner(String email) {
        WebElement emailInputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.learnerEmailInput));
        emailInputElement.sendKeys(email);
        // Implement logic to select the learner for unassignment
    }

    public void clickUnassignSelectedButton() {
        WebElement unassignButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.unassignSelectedButton));
        unassignButton.click();
    }

    public void confirmUnassignment() {
        if (Locators.confirmUnassignButton != null) {
            WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.confirmUnassignButton));
            confirmButton.click();
        }
    }

    public void validateCountAfterUnassigning() {
        WebElement updatedCountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.updatedLearnersCount));
        int updatedCount = Integer.parseInt(updatedCountElement.getText());
        assert updatedCount == initialLearnersCount - 1 : "Learner count did not decrease after unassignment";
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}