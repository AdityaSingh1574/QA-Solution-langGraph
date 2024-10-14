package implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.Locators;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;

public class Implementation {
    private WebDriver driver;
    private WebDriverWait wait;
    private int initialAssignedLearnersCount;

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

    public void clickManageCourses() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.manageCourseSidebar)).click();
    }

    public void clickBatches() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.batchesSidebar)).click();
    }

    public void verifyBatchesPage() {
        // Add verification logic if needed
    }

    public void clickActionsIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.actionsIcon)).click();
    }

    public void selectAssignLearners() {
        // Since the locator is NULL, we'll use JavaScript to click the option
        if (Locators.assignLearnersOption.equals("NULL")) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='Assign Learners']")));
        }
    }

    public void verifyAssignLearnersPage() {
        // Add verification logic if needed
    }

    public void getInitialAssignedLearnersCount() {
        String countText = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.assignedLearnersCount)).getText();
        initialAssignedLearnersCount = Integer.parseInt(countText);
    }

    public void selectUnassignedLearner() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.unassignedLearnerCheckbox)).click();
    }

    public void goToNextPage() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.nextPageButton)).click();
    }

    public void clickAssignSelectedButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.assignSelectedButton)).click();
    }

    public void confirmAssignment() {
        // Since the locator is NULL, we'll use JavaScript to click the button
        if (Locators.confirmAssignmentButton.equals("NULL")) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[text()='Yes']")));
        }
    }

    public void validateAssignedLearnersCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.assignedLearnersCount));
        String newCountText = driver.findElement(Locators.assignedLearnersCount).getText();
        int newCount = Integer.parseInt(newCountText);
        assert newCount > initialAssignedLearnersCount : "Assigned learners count did not increase";
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}