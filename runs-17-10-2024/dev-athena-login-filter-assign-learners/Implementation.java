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

    public void launchUrl() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://dev-athena.geminisolutions.com/login");
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

    public void selectManageCourses() {
        WebElement manageCourseElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.manageCourses));
        manageCourseElement.click();
    }

    public void selectBatches() {
        WebElement batchesElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.batches));
        batchesElement.click();
    }

    public void verifyBatchesPage() {
        // Implement verification logic for batches page
    }

    public void clickActionsIcon() {
        // Implement click action for actions icon (Xpath not provided)
    }

    public void selectAssignLearners() {
        // Implement select action for Assign Learners option (Xpath not provided)
    }

    public void verifyAssignLearnersPage() {
        // Implement verification logic for assign learners page
    }

    public void getAssignedLearnersCount() {
        WebElement countElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.assignedLearnersCount));
        String count = countElement.getText();
        System.out.println("Assigned Learners Count: " + count);
    }

    public void expandCategoryDropdown() {
        WebElement categoryDropdownElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.categoryDropdown));
        categoryDropdownElement.click();
    }

    public void selectECCategory() {
        WebElement ecOptionElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.ecOption));
        ecOptionElement.click();
    }

    public void expandSelectedCategoryDropdown() {
        WebElement selectedCategoryDropdownElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.selectedCategoryDropdown));
        selectedCategoryDropdownElement.click();
    }

    public void selectQASubcategory() {
        // Implement select action for QA option (Xpath not provided)
    }

    public void verifyFilteredRecords() {
        WebElement filteredRecordsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.filteredRecords));
        String filteredRecords = filteredRecordsElement.getText();
        System.out.println("Filtered Records: " + filteredRecords);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}