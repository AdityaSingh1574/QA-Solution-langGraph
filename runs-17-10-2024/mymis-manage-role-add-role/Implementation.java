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

    public void navigateToManageRole() {
        WebElement administrationsElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.administrationsSpan));
        administrationsElement.click();
    }

    public void verifyHomepageRedirection() {
        // Implement logic to verify homepage redirection
        // This could involve checking for a specific element on the homepage
    }

    public void navigateToManageRolePage() {
        WebElement manageRoleElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.manageRoleLink));
        manageRoleElement.click();
    }

    public void verifyManageRolePageRedirection() {
        // Implement logic to verify Manage Role page redirection
        // This could involve checking for a specific element on the Manage Role page
    }

    public void enterRoleName(String roleName) {
        // Note: The roleNameInput locator is null in the provided Locators class
        // You may need to update the Locators class with the correct XPath for this element
        if (Locators.roleNameInput != null) {
            WebElement roleNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.roleNameInput));
            roleNameElement.sendKeys(roleName);
        } else {
            System.out.println("Role name input locator is not defined.");
        }
    }

    public void clickAddRoleButton() {
        WebElement addRoleButtonElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.addRoleButton));
        addRoleButtonElement.click();
    }

    public void verifyRoleAdded() {
        // Implement logic to verify that the role was added successfully
        // This could involve checking for a success message or verifying the role in a list
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}