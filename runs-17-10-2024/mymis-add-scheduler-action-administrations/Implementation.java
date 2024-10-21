package implementation;

import locators.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

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

    public void verifyHomepageRedirect() {
        // Implement logic to verify homepage redirect
        // This could involve checking for a specific element on the homepage
    }

    public void navigateToManageScheduler() {
        WebElement manageSchedulerElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.manageSchedulerLink));
        manageSchedulerElement.click();
    }

    public void verifyManageSchedulerPage() {
        // Implement logic to verify Manage Scheduler page
        // This could involve checking for a specific element on the Manage Scheduler page
    }

    public void clickAddSchedulerActionButton() {
        WebElement addSchedulerActionElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.addSchedulerActionButton));
        addSchedulerActionElement.click();
    }

    public void enterSchedulerName(String name) {
        WebElement schedulerNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.schedulerNameInput));
        schedulerNameElement.sendKeys(name);
    }

    public void enterDescription(String description) {
        WebElement descriptionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.descriptionInput));
        descriptionElement.sendKeys(description);
    }

    public void enterFunctionName(String functionName) {
        WebElement functionNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.functionNameInput));
        functionNameElement.sendKeys(functionName);
    }

    public void clickFinalAddButton() {
        WebElement addButtonElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.addButton));
        addButtonElement.click();
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}