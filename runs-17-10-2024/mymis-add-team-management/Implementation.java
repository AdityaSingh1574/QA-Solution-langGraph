package implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    public void verifyHomepageRedirect() {
        // Implement logic to verify homepage redirect
        // This could be checking for a specific element on the homepage
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.teamManagementSpan));
    }

    public void navigateToTeamInfo() {
        WebElement teamManagementElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.teamManagementSpan));
        teamManagementElement.click();
        WebElement teamInfoElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.teamInformationLink));
        teamInfoElement.click();
    }

    public void verifyTeamInformationPage() {
        // Implement logic to verify Team Information page
        // This could be checking for a specific element on the Team Information page
        wait.until(ExpectedConditions.urlContains("TeamInformation"));
    }

    public void enterTeamName(String teamName) {
        // Since the xpath for team name input is NULL, we'll need to locate it differently
        // This is a placeholder and might need to be adjusted based on the actual page structure
        WebElement teamNameElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("teamName")));
        teamNameElement.sendKeys(teamName);
    }

    public void selectWeekStartDay(String weekStartDay) {
        // Since the xpath for week start day dropdown is NULL, we'll need to locate it differently
        // This is a placeholder and might need to be adjusted based on the actual page structure
        WebElement weekStartDayElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("weekStartDay")));
        Select weekStartDaySelect = new Select(weekStartDayElement);
        weekStartDaySelect.selectByVisibleText(weekStartDay);
    }

    public void selectDepartment(String department) {
        // Since the xpath for department dropdown is NULL, we'll need to locate it differently
        // This is a placeholder and might need to be adjusted based on the actual page structure
        WebElement departmentElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("department")));
        Select departmentSelect = new Select(departmentElement);
        departmentSelect.selectByVisibleText(department);
    }

    public void selectTeamHead(String teamHead) {
        // Since the xpath for team head dropdown is NULL, we'll need to locate it differently
        // This is a placeholder and might need to be adjusted based on the actual page structure
        WebElement teamHeadElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("teamHead")));
        Select teamHeadSelect = new Select(teamHeadElement);
        teamHeadSelect.selectByVisibleText(teamHead);
    }

    public void clickSaveButton() {
        WebElement saveButtonElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.saveButton));
        saveButtonElement.click();
    }

    public void verifyTeamCreation() {
        // Implement logic to verify team creation
        // This could be checking for a success message or the presence of the new team in a list
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Team created successfully')]")));
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}