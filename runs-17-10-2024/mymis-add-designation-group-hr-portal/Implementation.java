package implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import locators.Locators;
import java.time.Duration;

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

    public void enterUsername(String username) {
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.usernameInput));
        usernameElement.sendKeys(username);
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
        // This could involve checking for a specific element on the dashboard
    }

    public void navigateToManageDesignation() {
        WebElement manageDesignationElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.manageDesignationLink));
        manageDesignationElement.click();
    }

    public void verifyManageDesignationPage() {
        // Implement verification logic for Manage Designation page
        // This could involve checking for a specific element on the page
    }

    public void clickAddButton() {
        WebElement addButtonElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.addButton));
        addButtonElement.click();
    }

    public void enterDesignationGroupTitle(String title) {
        WebElement titleInputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.designationGroupTitleInput));
        titleInputElement.sendKeys(title);
    }

    public void clickSaveButton() {
        WebElement saveButtonElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.saveButton));
        saveButtonElement.click();
    }

    public void verifyNewDesignationGroupAdded() {
        // Implement verification logic for new designation group added
        // This could involve checking for a success message or the new group in a list
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}