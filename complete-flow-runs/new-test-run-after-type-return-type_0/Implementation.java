package implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.Locators;
import org.openqa.selenium.By;
import java.time.Duration;

public class Implementation {
    private WebDriver driver;
    private WebDriverWait wait;
    private int initialLearnerCount;

    public void launchUrl(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.emailInput)).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(Locators.passwordInput).sendKeys(password);
    }

    public void clickSignIn() {
        driver.findElement(Locators.signInButton).click();
    }

    public void selectSidebarOption(String option) {
        By locator = option.equals("Manage Courses") ? Locators.manageCourseSidebar : Locators.batchesSidebar;
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void verifyBatchesPage() {
        // Add verification logic here
    }

    public void clickActionsIcon(String record) {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.actionsIcon)).click();
    }

    public void selectDropdownOption(String option) {
        // Since the locator is null, we'll need to implement a custom logic to find and click the option
        // This is a placeholder and needs to be implemented based on the actual page structure
    }

    public void verifyAssignLearnersPage() {
        // Add verification logic here
    }

    public void getLearnerCount() {
        String countText = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.assignedLearnersCount)).getText();
        initialLearnerCount = Integer.parseInt(countText);
    }

    public void unassignLearner(String email) {
        driver.findElement(Locators.learnerEmailInput).sendKeys(email);
        // Additional steps to select the learner might be needed
    }

    public void clickButton(String buttonText) {
        if (buttonText.equals("unassign selected")) {
            driver.findElement(Locators.unassignSelectedButton).click();
        }
        // Add logic for other buttons if needed
    }

    public void confirmAction(String buttonText) {
        // Since the locator is null, we'll need to implement a custom logic to find and click the confirmation button
        // This is a placeholder and needs to be implemented based on the actual page structure
    }

    public void validateUpdatedCount() {
        String updatedCountText = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.updatedLearnersCount)).getText();
        int updatedCount = Integer.parseInt(updatedCountText);
        assert updatedCount == initialLearnerCount - 1 : "Learner count did not decrease as expected";
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}