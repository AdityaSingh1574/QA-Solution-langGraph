package implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

import static org.junit.Assert.assertTrue;

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

    public void enterUserId(String userId) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.USERNAME_INPUT)).sendKeys(userId);
    }

    public void enterPassword(String password) {
        driver.findElement(LoginPageLocators.PASSWORD_INPUT).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(LoginPageLocators.LOGIN_BUTTON).click();
    }

    public void verifyHomepage() {
        // Add verification logic for homepage
        assertTrue(driver.getCurrentUrl().contains("mymis.geminisolutions.com"));
    }

    public void navigateToLeaveManagement() {
        wait.until(ExpectedConditions.elementToBeClickable(LeaveManagementPageLocators.UPDATE_LINK)).click();
    }

    public void verifyLeaveManagementPage() {
        // Add verification logic for Leave Management Update page
        assertTrue(driver.getCurrentUrl().contains("LeaveManagement/Update"));
    }

    public void selectFirstFinancialYear() {
        wait.until(ExpectedConditions.elementToBeClickable(LeaveManagementPageLocators.FINANCIAL_YEAR_DROPDOWN)).click();
        // Add logic to select the first option
    }

    public void selectActiveEmployeeStatus() {
        driver.findElement(LeaveManagementPageLocators.EMPLOYEE_STATUS_DROPDOWN).click();
        // Add logic to select 'Active' status
    }

    public void searchForEmployee(String employeeName) {
        driver.findElement(LeaveManagementPageLocators.EMPLOYEE_SEARCH_INPUT).sendKeys(employeeName);
    }

    public void selectEmployee(String employeeName) {
        // Add logic to select the employee from search results
    }

    public void clickApplyLeaveButton() {
        driver.findElement(LeaveManagementPageLocators.APPLY_LEAVE_BUTTON).click();
    }

    public void verifyLeaveApplicationPage() {
        // Add verification logic for Leave Application page
        assertTrue(driver.getCurrentUrl().contains("LeaveApplication"));
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}