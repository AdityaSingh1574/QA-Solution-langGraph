package implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
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
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.usernameInput));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.usernameInput));
        driver.findElement(Locators.usernameInput).sendKeys(userId);
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

    public void verifyHomepageRedirection() {
        // Implement logic to verify homepage redirection
        // This might involve checking for a specific element on the homepage
    }

    public void navigateToTeamInfo() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.teamInformationLink));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.teamInformationLink));
        driver.findElement(Locators.teamInformationLink).click();
    }

    public void verifyTeamManagementPage() {
        // Implement logic to verify team management page
        // This might involve checking for a specific element on the team management page
    }

    public void clickViewTeam() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.viewTeamButton));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.viewTeamButton));
        driver.findElement(Locators.viewTeamButton).click();
    }

    public void clickDelete() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.deleteButton));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.deleteButton));
        driver.findElement(Locators.deleteButton).click();
    }

    public void confirmDeletion() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.confirmDeleteButton));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.confirmDeleteButton));
        driver.findElement(Locators.confirmDeleteButton).click();
    }

    public void verifyTeamInformationPageRedirection() {
        // Implement logic to verify redirection to team information page
        // This might involve checking for a specific element on the team information page
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}