package implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import locators.Locators;
import org.openqa.selenium.Keys;
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.usernameInput)).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(Locators.passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(Locators.loginButton).click();
    }

    public void verifyHomepage() {
        // Add verification logic for homepage
        wait.until(ExpectedConditions.urlContains("mymis.geminisolutions.com"));
    }

    public void navigateToManageTeamTask(String linkText) {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.manageTaskTeamLink)).click();
    }

    public void verifyManageTaskTeamPage() {
        // Add verification logic for Manage Task Team page
        wait.until(ExpectedConditions.urlContains("ManageTaskTeam"));
    }

    public void changeEntries(int entries) {
        // Implementation for changing entries
        // Note: The locator for entries dropdown is not provided, so this is a placeholder
        System.out.println("Changing entries to " + entries);
    }

    public void enterSearchQuery(String query) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.searchInput)).sendKeys(query);
    }

    public void pressEnter() {
        driver.findElement(Locators.searchInput).sendKeys(Keys.ENTER);
    }

    public void verifySearchResults() {
        // Add verification logic for search results
        // This is a placeholder as the exact verification method is not specified
        System.out.println("Verifying search results");
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}