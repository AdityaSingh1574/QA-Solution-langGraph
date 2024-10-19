package implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import java.time.Duration;
import locators.Locators;

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

    public void navigateToManageTeamTask(String linkText) {
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.manageTaskTeamLink));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.manageTaskTeamLink));
        driver.findElement(Locators.manageTaskTeamLink).click();
    }

    public void changeEntries(int entries) {
        // As the locator for entries dropdown is not provided (NULL), we'll skip this step
        System.out.println("Changing entries to " + entries + " (skipped due to missing locator)");
    }

    public void searchForTask(String searchText) {
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.searchInput));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.searchInput));
        driver.findElement(Locators.searchInput).sendKeys(searchText);
    }

    public void pressEnter() {
        driver.findElement(Locators.searchInput).sendKeys(Keys.ENTER);
    }

    public void verifyManageTaskTeamPage() {
        // Add verification logic here
        System.out.println("Verifying Manage Task Team page");
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}