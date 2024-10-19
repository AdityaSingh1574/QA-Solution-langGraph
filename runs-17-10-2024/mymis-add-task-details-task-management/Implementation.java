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
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.usernameInput));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.usernameInput));
        driver.findElement(Locators.usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.passwordInput));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.passwordInput));
        driver.findElement(Locators.passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.loginButton));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.loginButton));
        driver.findElement(Locators.loginButton).click();
    }

    public void navigateToManageTaskSubDetails() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.manageTaskSubDetails1Link));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.manageTaskSubDetails1Link));
        driver.findElement(Locators.manageTaskSubDetails1Link).click();
    }

    public void verifyHomepageRedirection() {
        // Implement logic to verify homepage redirection
        // This might involve checking for a specific element on the homepage
    }

    public void clickAddNewTaskDetailsButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.addNewTaskSubDetail1Button));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.addNewTaskSubDetail1Button));
        driver.findElement(Locators.addNewTaskSubDetail1Button).click();
    }

    public void enterTaskName(String taskName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.enterTaskSubDetail1NameInput));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.enterTaskSubDetail1NameInput));
        driver.findElement(Locators.enterTaskSubDetail1NameInput).sendKeys(taskName);
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.finalAddTaskSubDetail1Button));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.finalAddTaskSubDetail1Button));
        driver.findElement(Locators.finalAddTaskSubDetail1Button).click();
    }

    public void verifyRedirectionToManageTaskSubDetailPage() {
        // Implement logic to verify redirection to Manage Task Sub Detail page
        // This might involve checking for a specific element on that page
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}