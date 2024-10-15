package implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.Locators;

import java.time.Duration;

public class Implementation {
    private WebDriver driver;
    private WebDriverWait wait;
    private int initialCount;

    public void launchUrl() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://dev-athena.geminisolutions.com/login");
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.emailInput)).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(Locators.passwordInput).sendKeys(password);
    }

    public void clickSignInButton() {
        driver.findElement(Locators.signInButton).click();
    }

    public void verifyDashboardRedirect() {
        wait.until(ExpectedConditions.urlContains("dashboard"));
    }

    public void selectManageCourses() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.manageCoursesSidebar)).click();
    }

    public void selectBatches() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.batchesSidebar)).click();
    }

    public void verifyBatchesPageRedirect() {
        wait.until(ExpectedConditions.urlContains("batches"));
    }

    public void clickActionsIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.actionsIcon)).click();
    }

    public void selectAssignLearners() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.assignLearnersOption)).click();
    }

    public void verifyAssignLearnersPageRedirect() {
        wait.until(ExpectedConditions.urlContains("assign-learners"));
    }

    public void getCurrentAssignedLearnersCount() {
        String countText = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.assignedLearnersCount)).getText();
        initialCount = Integer.parseInt(countText.replaceAll("\\D+", ""));
    }

    public void assignLearner(String email) {
        // Implementation for assigning a learner with the given email
        // This step might involve searching for the learner and selecting them
    }

    public void clickAssignSelectedButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.assignSelectedButton)).click();
    }

    public void confirmAssignment() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.confirmYesButton)).click();
    }

    public void validateCountAfterAssigning() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.assignedLearnersCount));
        String newCountText = driver.findElement(Locators.assignedLearnersCount).getText();
        int newCount = Integer.parseInt(newCountText.replaceAll("\\D+", ""));
        assert newCount == initialCount + 1 : "Learner count did not increase as expected";
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}