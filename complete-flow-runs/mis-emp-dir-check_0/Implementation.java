package implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

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
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.USERNAME_INPUT[0]));
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.PASSWORD_INPUT[0]));
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.LOGIN_BUTTON[0]));
        loginButton.click();
    }

    public void verifyHomepage() {
        // Add verification logic for homepage
        assertTrue(driver.getCurrentUrl().contains("mymis.geminisolutions.com"));
    }

    public void clickMenuItem(String menuItem) {
        if (menuItem.equals("Employee Directory")) {
            WebElement employeeDirectoryLink = wait.until(ExpectedConditions.elementToBeClickable(Locators.EMPLOYEE_DIRECTORY_LINK[0]));
            employeeDirectoryLink.click();
        }
    }

    public void verifyEmployeeDirectoryPage() {
        // Add verification logic for Employee Directory page
        assertTrue(driver.getCurrentUrl().contains("EmployeeDirectory"));
    }

    public void selectEntries(String entries) {
        // Implementation for selecting entries from dropdown
        // Note: The locator for this element is not provided in the Locators.java file
        System.out.println("Selecting " + entries + " entries (implementation needed)");
    }

    public void enterSearchTerm(String searchTerm) {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.SEARCH_INPUT[0]));
        searchInput.sendKeys(searchTerm);
    }

    public void pressEnter() {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.SEARCH_INPUT[0]));
        searchInput.sendKeys(Keys.ENTER);
    }

    public void verifySearchResults(String searchTerm) {
        // Add verification logic for search results
        // This is a placeholder and should be implemented based on the actual page structure
        assertTrue(driver.getPageSource().contains(searchTerm));
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}