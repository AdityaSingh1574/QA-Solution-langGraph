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

    public void verifySuccessfulLogin() {
        // Implement logic to verify successful login
        // This could be checking for a specific element on the dashboard
    }

    public void navigateToParameterMaster() {
        // Implement navigation to Parameter Master
        // This might involve clicking through multiple menu items
    }

    public void selectAppraisalCycle(String cycle) {
        WebElement appraisalCycleElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.appraisalCycleDropdown));
        appraisalCycleElement.click();
        // Implement selection of the specific cycle
    }

    public void selectLocation(String location) {
        WebElement locationElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.locationDropdown));
        locationElement.click();
        // Implement selection of the specific location
    }

    public void selectVertical(String vertical) {
        WebElement verticalElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.verticalDropdown));
        verticalElement.click();
        // Implement selection of the specific vertical
    }

    public void selectDesignation(String designation) {
        WebElement designationElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.designationDropdown));
        designationElement.click();
        // Implement selection of the specific designation
    }

    public void clickSearchButton() {
        WebElement searchButtonElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.searchButton));
        searchButtonElement.click();
    }

    public void verifyParameterMasterPage() {
        // Implement verification that user is on Parameter Master page
        // This could involve checking for a specific element or title
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}