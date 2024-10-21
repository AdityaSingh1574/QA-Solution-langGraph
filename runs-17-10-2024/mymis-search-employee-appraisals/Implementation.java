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
        driver.get("https://mymis.geminisolutions.com/Account/Login");
    }

    public void enterUserId(String userId) {
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.usernameInput));
        usernameElement.sendKeys(userId);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.passwordInput));
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.loginButton));
        loginButtonElement.click();
    }

    public void verifyDashboardRedirection() {
        // Implement dashboard verification logic
    }

    public void navigateToEmployeeAppraisal() {
        WebElement appraisalManagementElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.appraisalManagementSpan));
        appraisalManagementElement.click();
        WebElement employeesAppraisalElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.employeesAppraisalLink));
        employeesAppraisalElement.click();
    }

    public void verifyAppraisalManagementPage() {
        // Implement appraisal management page verification logic
    }

    public void selectAppraisalCycle(String cycle) {
        WebElement appraisalCycleElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.appraisalCycleDropdown));
        appraisalCycleElement.click();
        // Implement logic to select the specific cycle
    }

    public void selectDcChair(String dcChair) {
        WebElement dcChairElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.dcChairDropdown));
        dcChairElement.click();
        // Implement logic to select the specific DC chair
    }

    public void clickSearchButton() {
        WebElement searchButtonElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.searchButton));
        searchButtonElement.click();
    }

    public void verifyEmployeesAppraisalPage() {
        // Implement employees appraisal page verification logic
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}