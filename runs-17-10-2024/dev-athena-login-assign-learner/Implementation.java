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
    private int initialLearnerCount;

    public void launchUrl() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://dev-athena.geminisolutions.com");
    }

    public void enterCredentials(String email, String password) {
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.emailInput));
        emailElement.sendKeys(email);
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.passwordInput));
        passwordElement.sendKeys(password);
    }

    public void clickSignInButton() {
        WebElement signInElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.signInButton));
        signInElement.click();
    }

    public void selectManageCourses() {
        WebElement manageCourseElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.manageCourseSidebar));
        manageCourseElement.click();
    }

    public void selectBatches() {
        WebElement batchesElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.batchesSidebar));
        batchesElement.click();
    }

    public void verifyDashboardRedirection() {
        // Implement logic to verify dashboard redirection
    }

    public void clickActionsIcon() {
        // Implement logic to click actions icon
        // Note: Locator is NULL, so you might need to find a way to locate this element
    }

    public void selectAssignLearners() {
        // Implement logic to select Assign Learners option
        // Note: Locator is NULL, so you might need to find a way to locate this element
    }

    public void verifyAssignLearnersPageRedirection() {
        // Implement logic to verify redirection to assign learners page
    }

    public void getCurrentAssignedLearnersCount() {
        WebElement countElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.assignedLearnersCount));
        initialLearnerCount = Integer.parseInt(countElement.getText());
    }

    public void assignLearner(String email) {
        // Implement logic to assign a learner
        // This might involve finding an input field and entering the email
    }

    public void clickAssignSelectedButton() {
        WebElement assignButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.assignSelectedButton));
        assignButton.click();
    }

    public void confirmAssignment() {
        // Implement logic to confirm assignment
        // Note: Locator is NULL, so you might need to find a way to locate this element
    }

    public void validateCountAfterAssigning() {
        WebElement countElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.assignedLearnersCount));
        int newCount = Integer.parseInt(countElement.getText());
        assert newCount == initialLearnerCount + 1 : "Learner count did not increase as expected";
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}