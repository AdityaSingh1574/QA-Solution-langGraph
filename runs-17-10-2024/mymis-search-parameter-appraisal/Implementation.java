package implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    public void verifyHomepage() {
        // Implement logic to verify homepage
        // For example, check for a specific element on the homepage
    }

    public void navigateToParameterMaster() {
        WebElement appraisalManagementElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.appraisalManagementSpan));
        appraisalManagementElement.click();
        WebElement parameterMasterElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.parameterMasterLink));
        parameterMasterElement.click();
    }

    public void verifyParameterMasterPage() {
        // Implement logic to verify Parameter Master page
        // For example, check for a specific element on the Parameter Master page
    }

    public void selectCompetency(String competency) {
        // Implement logic to select competency from dropdown
        // Note: Locator for competencyDropdown is null in the provided locators
    }

    public void selectYear(String year) {
        // Implement logic to select year from dropdown
        // Note: Locator for yearDropdown is null in the provided locators
    }

    public void selectStatus(String status) {
        // Implement logic to select status from dropdown
        // Note: Locator for statusDropdown is null in the provided locators
    }

    public void clickSearchButton() {
        // Implement logic to click search button
        // Note: Locator for searchButton is null in the provided locators
    }

    public void verifySearchResults() {
        // Implement logic to verify search results
        // For example, check for the presence of search result elements
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}