package implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.Locators;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class Implementation {
    private WebDriver driver;
    private WebDriverWait wait;

    public void launchUrl() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://mymis.geminisolutions.com");
    }

    public void enterUserId(String userId) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.usernameInput)).sendKeys(userId);
    }

    public void enterPassword(String password) {
        driver.findElement(Locators.passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(Locators.loginButton).click();
    }

    public void navigateToTeamInfo() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.teamManagementSpan)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Locators.teamInformationLink)).click();
    }

    public void verifyDashboardRedirection() {
        // Implement logic to verify dashboard redirection
        // This might involve checking for a specific element on the dashboard
    }

    public void enterTeamName(String teamName) {
        // Implement logic to enter team name
        // Note: The xpath for this element was not provided in the locators
    }

    public void selectWeekStartDay(String day) {
        // Implement logic to select week start day
        // Note: The xpath for this element was not provided in the locators
    }

    public void selectDepartment(String department) {
        // Implement logic to select department
        // Note: The xpath for this element was not provided in the locators
    }

    public void selectTeamHead(String teamHead) {
        // Implement logic to select team head
        // Note: The xpath for this element was not provided in the locators
    }

    public void clickSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.saveButton)).click();
    }

    public void verifyTeamInformationPageRedirection() {
        // Implement logic to verify redirection to Team Information page
        // This might involve checking for a specific element on the Team Information page
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}