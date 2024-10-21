package implementation;

import locators.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
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

    public void verifyHomepage() {
        // Implement verification logic for homepage
        // For example, check for a specific element on the homepage
    }

    public void navigateToManageStaffMember() {
        WebElement userManagementElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.userManagementSpan));
        userManagementElement.click();
        WebElement manageStaffMembersElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.manageStaffMembersLink));
        manageStaffMembersElement.click();
    }

    public void clickAddNewStaffMemberButton() {
        WebElement addNewStaffMemberElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.addNewStaffMemberButton));
        addNewStaffMemberElement.click();
    }

    public void enterName(String name) {
        WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.nameInput));
        nameElement.sendKeys(name);
    }

    public void enterPhoneNumber(String phoneNumber) {
        WebElement phoneNumberElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.phoneNumberInput));
        phoneNumberElement.sendKeys(phoneNumber);
    }

    public void clickLocationDropdown() {
        // Implementation for clicking location dropdown
        // Note: The xpath for locationDropdown is null in the provided locators
    }

    public void selectLocation(String location) {
        // Implementation for selecting location from dropdown
        // Note: This step might need to be adjusted based on the actual dropdown implementation
    }

    public void clickSaveButton() {
        WebElement saveButtonElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.saveButton));
        saveButtonElement.click();
    }

    public void verifyManageStaffMemberPage() {
        // Implement verification logic for Manage Staff Member page
        // For example, check for a specific element on the page
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}