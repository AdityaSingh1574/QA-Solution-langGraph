package implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.passwordInput)).sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.loginButton)).click();
    }

    public void verifyDashboardRedirection() {
        // Implement dashboard verification logic
        // For example, check for a dashboard element
    }

    public void navigateToClientManagement() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.ecDcManagementLink)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Locators.manageClientLink)).click();
    }

    public void verifyClientManagementPage() {
        // Implement client management page verification logic
    }

    public void clickAddClientButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.addClientButton)).click();
    }

    public void fillClientName() {
        // Implement logic to fill client name
        // Note: The XPath for clientNameInput is "NULL" in the locators, so you may need to update it
    }

    public void fillAddress() {
        // Implement logic to fill address
        // Note: The XPath for addressInput is "NULL" in the locators, so you may need to update it
    }

    public void fillCity() {
        // Implement logic to fill city
        // Note: The XPath for cityInput is "NULL" in the locators, so you may need to update it
    }

    public void fillCountry() {
        // Implement logic to fill country
        // Note: The XPath for countryInput is "NULL" in the locators, so you may need to update it
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.addButton)).click();
    }

    public void verifyManageClientPageRedirection() {
        // Implement manage client page redirection verification logic
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}