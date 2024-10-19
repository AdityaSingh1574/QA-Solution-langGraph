package implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Keys;
import io.github.bonigarcia.wdm.WebDriverManager;
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
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.usernameInput));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.usernameInput));
        driver.findElement(Locators.usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.passwordInput));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.passwordInput));
        driver.findElement(Locators.passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.loginButton));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.loginButton));
        driver.findElement(Locators.loginButton).click();
    }

    public void navigateToClientManagement() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.ecDcManagementLink));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.ecDcManagementLink));
        driver.findElement(Locators.ecDcManagementLink).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.manageClientLink));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.manageClientLink));
        driver.findElement(Locators.manageClientLink).click();
    }

    public void verifyHomepageRedirect() {
        // Add logic to verify homepage redirect
        // This could involve checking for a specific element on the homepage
    }

    public void searchForClient(String clientName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.searchInput));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.searchInput));
        driver.findElement(Locators.searchInput).sendKeys(clientName);
    }

    public void pressEnterKey() {
        driver.findElement(Locators.searchInput).sendKeys(Keys.ENTER);
    }

    public void verifyManageClientPageRedirect() {
        // Add logic to verify redirect to Manage Client page
        // This could involve checking for a specific element on the Manage Client page
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}