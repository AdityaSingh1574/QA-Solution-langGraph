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

    public void enterUserId(String userId) {
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.usernameInput));
        usernameElement.sendKeys(userId);
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
        // This could be checking for a specific element that's only present on the homepage
    }

    public void navigateToCompetencyForm() {
        WebElement competencyFormElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.competencyFormLink));
        competencyFormElement.click();
    }

    public void verifyCompetencyFormPage() {
        // Implement logic to verify Competency Form page
        // This could be checking for a specific element that's only present on the Competency Form page
    }

    public void selectAppraisalCycle(String cycle) {
        // Implement logic to select appraisal cycle
        // Note: Locator is null in the provided locators file
    }

    public void selectLocation(String location) {
        // Implement logic to select location
        // Note: Locator is null in the provided locators file
    }

    public void selectVertical(String vertical) {
        // Implement logic to select vertical
        // Note: Locator is null in the provided locators file
    }

    public void selectDesignation(String designation) {
        // Implement logic to select designation
        // Note: Locator is null in the provided locators file
    }

    public void clickSearchButton() {
        // Implement logic to click search button
        // Note: Locator is null in the provided locators file
    }

    public void verifySearchResults() {
        // Implement logic to verify search results
        // This could be checking for the presence of search result elements
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}