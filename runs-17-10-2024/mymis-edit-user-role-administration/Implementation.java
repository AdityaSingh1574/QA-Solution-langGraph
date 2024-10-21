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
        // Implement logic to verify homepage
        // For example, check for a specific element on the homepage
    }

    public void navigateToUserRoleSection() {
        WebElement administrationsElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.administrationsSpan));
        administrationsElement.click();
        WebElement userRoleElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.userRoleLink));
        userRoleElement.click();
    }

    public void verifyUserRolePage() {
        // Implement logic to verify User Role page
        // For example, check for a specific element on the User Role page
    }

    public void selectUserToEdit(String username) {
        // Implement logic to select the user to edit
        // This might involve searching for the user and clicking an edit button
        WebElement editRoleElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.editRoleButton));
        editRoleElement.click();
    }

    public void selectRole(String role) {
        WebElement roleDropdownElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.userRoleDropdown));
        roleDropdownElement.click();
        // Implement logic to select the specific role from the dropdown
    }

    public void clickUpdateButton() {
        WebElement updateButtonElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.updateButton));
        updateButtonElement.click();
    }

    public void verifyRoleUpdate() {
        // Implement logic to verify the role was updated successfully
        // This might involve checking for a success message or verifying the updated role in the user list
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}