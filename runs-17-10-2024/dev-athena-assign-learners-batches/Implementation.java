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

    public void verifyDashboardRedirection() {
        // Implement logic to verify dashboard redirection
    }

    public void selectManageCourses() {
        WebElement manageCourseElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.manageCoursesSidebar));
        manageCourseElement.click();
    }

    public void selectBatches() {
        WebElement batchesElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.batchesSidebar));
        batchesElement.click();
    }

    public void verifyBatchesPageRedirection() {
        // Implement logic to verify batches page redirection
    }

    public void clickActionsIcon() {
        // Implement logic to click actions icon (Locator is null, so you might need to find a way to locate this element)
    }

    public void selectAssignLearners() {
        // Implement logic to select Assign Learners option (Locator is null, so you might need to find a way to locate this element)
    }

    public void verifyAssignLearnersPageRedirection() {
        // Implement logic to verify assign learners page redirection
    }

    public void getAssignedLearnersCount() {
        WebElement countElement = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.assignedLearnersCount));
        String count = countElement.getText();
        System.out.println("Assigned Learners Count: " + count);
    }

    public void selectUnassignedLearner() {
        WebElement learnerCheckbox = wait.until(ExpectedConditions.elementToBeClickable(Locators.unassignedLearnerCheckbox));
        learnerCheckbox.click();
    }

    public void navigateToNextPage() {
        WebElement nextPageButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.nextPageButton));
        nextPageButton.click();
    }

    public void clickAssignSelectedButton() {
        WebElement assignButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.assignSelectedButton));
        assignButton.click();
    }

    public void confirmAssignment() {
        // Implement logic to confirm assignment (Locator is null, so you might need to find a way to locate this element)
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}