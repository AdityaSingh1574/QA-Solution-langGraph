package implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.Locators;

import java.time.Duration;

public class Implementation {
    private WebDriver driver;
    private WebDriverWait wait;

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

    public void verifySuccessfulLogin() {
        // Implement verification logic
    }

    public void selectManageCourses() {
        WebElement manageCourses = wait.until(ExpectedConditions.elementToBeClickable(Locators.manageCoursesSidebar));
        manageCourses.click();
    }

    public void selectBatches() {
        WebElement batches = wait.until(ExpectedConditions.elementToBeClickable(Locators.batchesSidebar));
        batches.click();
    }

    public void verifyDashboardRedirection() {
        // Implement verification logic
    }

    public void clickActionsIcon() {
        // Implement when XPath is available
    }

    public void selectAssignLearners() {
        // Implement when XPath is available
    }

    public void verifyAssignLearnersPageRedirection() {
        // Implement verification logic
    }

    public void expandCategoryDropdown() {
        WebElement categoryDropdown = wait.until(ExpectedConditions.elementToBeClickable(Locators.categoryDropdown));
        categoryDropdown.click();
    }

    public void selectEC() {
        WebElement ecOption = wait.until(ExpectedConditions.elementToBeClickable(Locators.ecOption));
        ecOption.click();
    }

    public void expandSelectedCategoryDropdown() {
        WebElement selectedCategoryDropdown = wait.until(ExpectedConditions.elementToBeClickable(Locators.selectedCategoryDropdown));
        selectedCategoryDropdown.click();
    }

    public void selectQA() {
        // Implement when XPath is available
    }

    public void verifyAssignedLearnersCount() {
        WebElement learnersCount = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.assignedLearnersCount));
        // Implement verification logic
    }

    public void unassignLearner() {
        WebElement unassignButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.unassignButton));
        unassignButton.click();
    }

    public void verifyUpdatedAssignedLearnersCount() {
        // Implement verification logic
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}