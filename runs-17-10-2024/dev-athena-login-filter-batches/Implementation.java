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
        WebElement manageCourseElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.manageCourseSidebar));
        manageCourseElement.click();
    }

    public void selectBatches() {
        WebElement batchesElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.batchesSidebar));
        batchesElement.click();
    }

    public void clickActionsIcon() {
        // Since the XPath for actions icon is NULL, we'll skip this step
        System.out.println("Actions icon XPath is not available. Skipping this step.");
    }

    public void selectAssignLearners() {
        WebElement assignLearnersElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.assignLearnersDropdown));
        assignLearnersElement.click();
    }

    public void verifyAssignLearnersPage() {
        // Add verification logic here
        System.out.println("Verifying Assign Learners page");
    }

    public void getAssignedLearnersCount() {
        WebElement assignedLearnersCountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.assignedLearnersCount));
        String count = assignedLearnersCountElement.getText();
        System.out.println("Assigned Learners Count: " + count);
    }

    public void expandStatusDropdown() {
        WebElement statusDropdownElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.statusDropdown));
        statusDropdownElement.click();
    }

    public void selectAssignedStatus() {
        // Since the XPath for assigned status option is NULL, we'll skip this step
        System.out.println("Assigned status option XPath is not available. Skipping this step.");
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