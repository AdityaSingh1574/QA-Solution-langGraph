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
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.usernameInput)).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(Locators.passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(Locators.loginButton).click();
    }

    public void verifyHomepage() {
        wait.until(ExpectedConditions.urlContains("Home"));
    }

    public void navigateToManageTeamTask(String linkText) {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.manageTaskTeamLink)).click();
    }

    public void verifyManageTaskTeamPage() {
        wait.until(ExpectedConditions.urlContains("ManageTaskTeam"));
    }

    public void changeEntries(int entries) {
        // Implementation for changing entries
        // Note: Locator for entries dropdown is not provided, so this is a placeholder
        System.out.println("Changing entries to " + entries);
    }

    public void enterSearchInput(String searchText) {
        // Implementation for entering search input
        // Note: Locator for search input is not provided, so this is a placeholder
        System.out.println("Entering search text: " + searchText);
    }

    public void pressEnter() {
        // Implementation for pressing enter
        // Note: Locator for search input is not provided, so this is a placeholder
        System.out.println("Pressing Enter key");
    }

    public void verifyFilteredResults(String searchText) {
        // Implementation for verifying filtered results
        // Note: This is a placeholder as we don't have specific locators for results
        System.out.println("Verifying filtered results for: " + searchText);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}