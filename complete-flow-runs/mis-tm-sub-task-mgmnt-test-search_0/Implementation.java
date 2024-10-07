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

    public void enterUserId(String userId) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.usernameInput)).sendKeys(userId);
    }

    public void enterPassword(String password) {
        driver.findElement(Locators.passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(Locators.loginButton).click();
    }

    public void navigateToManageTeamTask(String menuItem) {
        // Implementation depends on the actual structure of the page
        // This is a placeholder
        System.out.println("Navigating to " + menuItem);
    }

    public void verifyRedirectionToHomepage() {
        // Implement verification logic
        System.out.println("Verifying redirection to homepage");
    }

    public void navigateToManageTaskTeamPage() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.manageTaskTeamLink)).click();
    }

    public void changeEntries(int entries) {
        // Implementation depends on the actual structure of the dropdown
        // This is a placeholder
        System.out.println("Changing entries to " + entries);
    }

    public void searchFor(String searchTerm) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.searchInput)).sendKeys(searchTerm);
    }

    public void pressEnter() {
        driver.findElement(Locators.searchInput).sendKeys(Keys.ENTER);
    }

    public void verifySearchResults(String searchTerm) {
        // Implement verification logic
        System.out.println("Verifying search results for " + searchTerm);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}