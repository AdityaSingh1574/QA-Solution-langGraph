package implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.Locators;
import org.junit.Assert;

import java.time.Duration;

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
        if (Locators.actionsIcon != null) {
            wait.until(ExpectedConditions.elementToBeClickable(Locators.actionsIcon)).click();
        } else {
            System.out.println("Actions icon locator is not defined.");
        }
    }

    public void selectAssignLearners() {
        if (Locators.assignLearnersOption != null) {
            wait.until(ExpectedConditions.elementToBeClickable(Locators.assignLearnersOption)).click();
        } else {
            System.out.println("Assign Learners option locator is not defined.");
        }
    }

    public void verifyAssignLearnersPageRedirect() {
        wait.until(ExpectedConditions.urlContains("assign-learners"));
    }

    public void getCurrentAssignedLearnersCount() {
        String countText = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.assignedLearnersCount)).getText();
        initialLearnersCount = Integer.parseInt(countText);
    }

    public void unassignLearner(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.learnerEmailInput)).sendKeys(email);
    }

    public void clickUnassignSelectedButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.unassignSelectedButton)).click();
    }

    public void confirmUnassignment() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.confirmYesButton)).click();
    }

    public void validateNewAssignedLearnersCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.updatedLearnersCount));
        String newCountText = driver.findElement(Locators.updatedLearnersCount).getText();
        int newCount = Integer.parseInt(newCountText);
        Assert.assertTrue("New learners count should be less than initial count", newCount < initialLearnersCount);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}