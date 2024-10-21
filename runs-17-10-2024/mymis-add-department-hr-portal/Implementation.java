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

    public Implementation() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void launchUrl(String url) {
        driver.get(url);
        driver.manage().window().maximize();
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

    public void verifyHomepage() {
        // Implement logic to verify homepage
        // This could be checking for a specific element on the homepage
    }

    public void navigateToManageDepartmentTeams() {
        WebElement manageDepartmentTeamsElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.manageDepartmentTeamsLink));
        manageDepartmentTeamsElement.click();
    }

    public void clickAddDepartmentButton() {
        WebElement addDepartmentButtonElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.addNewDepartmentButton));
        addDepartmentButtonElement.click();
    }

    public void enterDepartmentName(String departmentName) {
        WebElement departmentNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.enterDepartmentNameTextarea));
        departmentNameElement.sendKeys(departmentName);
    }

    public void enterDepartmentDescription(String description) {
        WebElement departmentDescriptionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.enterDepartmentDescriptionTextarea));
        departmentDescriptionElement.sendKeys(description);
    }

    public void clickDepartmentHeadDropdown() {
        // Implement when the correct locator is provided
    }

    public void selectFromDropdown(String option) {
        // Implement dropdown selection logic
    }

    public void clickDivisionNameDropdown() {
        // Implement when the correct locator is provided
    }

    public void clickAddButton() {
        // Implement when the correct locator is provided
    }

    public void verifyManageDepartmentPage() {
        // Implement logic to verify Manage Department page
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}