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
    private int initialAssignedCount;

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

    public void clickSignInButton() {
        driver.findElement(Locators.signInButton).click();
    }

    public void selectFromSidebar(String option) {
        By locator = option.equals("Manage Courses") ? Locators.manageCoursesSpan : Locators.batchesSpan;
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void verifyDashboardRedirect() {
        // Implement verification logic
    }

    public void clickActionsIcon(String record) {
        // Implement click action
    }

    public void selectFromActionsDropdown(String option) {
        // Implement selection logic
    }

    public void verifyAssignLearnersPageRedirect() {
        // Implement verification logic
    }

    public void expandDropdown(String dropdown) {
        By locator = dropdown.equals("Category") ? Locators.categoryDropdown : Locators.selectedCategoryDropdown;
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void selectFromCategoryDropdown(String option) {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.ecOption)).click();
    }

    public void selectFromSelectedCategoryDropdown(String option) {
        // Implement selection logic for QA option
    }

    public void getAssignedLearnersCount() {
        String countText = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.assignedLearnersCount)).getText();
        initialAssignedCount = Integer.parseInt(countText.replaceAll("\\D+", ""));
    }

    public void unassignLearner() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.unassignButton)).click();
    }

    public void validateCountAfterUnassigning() {
        String newCountText = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.assignedLearnersCount)).getText();
        int newCount = Integer.parseInt(newCountText.replaceAll("\\D+", ""));
        assert newCount < initialAssignedCount : "Unassign operation failed";
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}