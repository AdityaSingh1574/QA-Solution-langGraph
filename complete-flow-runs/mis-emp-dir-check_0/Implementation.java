package implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import static org.junit.Assert.assertTrue;
import Locators.LoginPageLocators;
import Locators.MainPageLocators;

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
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.USERNAME_INPUT));
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.PASSWORD_INPUT));
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(LoginPageLocators.LOGIN_BUTTON));
        loginButton.click();
    }

    public void verifyHomepage() {
        // Implement logic to verify the homepage
        // For example, check for a specific element that exists only on the homepage
        assertTrue("Homepage not loaded", driver.getTitle().contains("MIS Homepage"));
    }

    public void navigateToMenuItem(String menuItem) {
        // Implement navigation logic
        // This is a placeholder as the exact navigation structure is not provided
        WebElement menuLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(menuItem)));
        menuLink.click();
    }

    public void verifyEmployeeDirectoryPage() {
        // Implement logic to verify the Employee Directory page
        assertTrue("Employee Directory page not loaded", driver.getCurrentUrl().contains("EmployeeDirectory"));
    }

    public void clickEntriesDropdown() {
        // Note: The ENTRIES_DROPDOWN locator was null in the provided Locators file
        // You may need to update this with the correct locator
        WebElement entriesDropdown = wait.until(ExpectedConditions.elementToBeClickable(MainPageLocators.ENTRIES_DROPDOWN));
        entriesDropdown.click();
    }

    public void selectDropdownOption(String option) {
        // Implement logic to select the dropdown option
        WebElement dropdownOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[text()='" + option + "']")));
        dropdownOption.click();
    }

    public void enterSearchTerm(String searchTerm) {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(MainPageLocators.SEARCH_INPUT));
        searchInput.clear();
        searchInput.sendKeys(searchTerm);
    }

    public void pressEnter() {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(MainPageLocators.SEARCH_INPUT));
        searchInput.sendKeys(Keys.ENTER);
    }

    public void verifySearchResults(String searchTerm) {
        // Implement logic to verify search results
        // This is a placeholder as the exact structure of search results is not provided
        WebElement searchResults = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'search-results')]")));
        assertTrue("Search results not displayed for " + searchTerm, searchResults.isDisplayed());
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}