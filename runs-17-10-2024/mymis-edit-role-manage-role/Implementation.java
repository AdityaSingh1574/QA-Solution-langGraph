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

    public Implementation() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void launchUrl(String url) {
        driver.get(url);
        driver.manage().window().maximize();
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

    public void navigateToManageRole() {
        WebElement administrationsElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.administrationsSpan));
        administrationsElement.click();
        WebElement manageRoleElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.manageRoleLink));
        manageRoleElement.click();
    }

    public void verifyHomepage() {
        // Implement logic to verify homepage
        // This could involve checking for a specific element on the homepage
    }

    public void selectRole(String roleName) {
        // Implement logic to select the role
        // This might involve finding and clicking on a role in a list or dropdown
    }

    public void changeRoleName(String newRoleName) {
        // Implement logic to change the role name
        // This might involve finding the input field and changing its value
    }

    public void clickUpdateRoleButton() {
        // Implement logic to click the update role button
        // Note: The locator for this button is not provided in the Locators class
    }

    public void verifyManageRolePage() {
        // Implement logic to verify the Manage Role page
        // This could involve checking for a specific element on the Manage Role page
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}