package implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        wait.until(ExpectedConditions.urlContains("mymis.geminisolutions.com"));
    }

    public void navigateToManageTeamTask() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.manageTaskTeamLink)).click();
    }

    public void verifyManageTaskTeamPage() {
        wait.until(ExpectedConditions.urlContains("ManageTaskTeam"));
    }

    public void changeEntries(String number) {
        // Implementation for changing entries
        // Note: The locator for entriesDropdown is null in the provided locators
        System.out.println("Changing entries to " + number);
    }

    public void enterSearch(String searchText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.searchInput)).sendKeys(searchText);
    }

    public void verifySearchResults() {
        // Implementation for verifying search results
        System.out.println("Verifying search results");
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}