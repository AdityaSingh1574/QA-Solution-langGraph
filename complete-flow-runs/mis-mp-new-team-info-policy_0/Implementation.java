package implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import static org.junit.Assert.assertTrue;
import static stepdefinitions.TeamManagementLocators.*;

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT)).sendKeys(userId);
    }

    public void enterPassword(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void verifyMISHomepage() {
        wait.until(ExpectedConditions.urlContains("mymis.geminisolutions.com"));
    }

    public void navigateToTeamInfo() {
        wait.until(ExpectedConditions.elementToBeClickable(TEAM_MANAGEMENT_SPAN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(TEAM_INFORMATION_LINK)).click();
    }

    public void verifyTeamInformationPage() {
        wait.until(ExpectedConditions.urlContains("TeamInformation"));
    }

    public void enterTeamName(String teamName) {
        // Note: TEAM_NAME_INPUT locator is null, so we can't implement this step
        // driver.findElement(TEAM_NAME_INPUT).sendKeys(teamName);
        System.out.println("Unable to enter team name due to missing locator");
    }

    public void selectWeekStartDay(String weekStartDay) {
        // Note: WEEK_START_DAY_DROPDOWN locator is null, so we can't implement this step
        // Select select = new Select(driver.findElement(WEEK_START_DAY_DROPDOWN));
        // select.selectByVisibleText(weekStartDay);
        System.out.println("Unable to select week start day due to missing locator");
    }

    public void selectDepartment(String department) {
        // Note: DEPARTMENT_DROPDOWN locator is null, so we can't implement this step
        // Select select = new Select(driver.findElement(DEPARTMENT_DROPDOWN));
        // select.selectByVisibleText(department);
        System.out.println("Unable to select department due to missing locator");
    }

    public void selectTeamHead(String teamHead) {
        // Note: TEAM_HEAD_DROPDOWN locator is null, so we can't implement this step
        // Select select = new Select(driver.findElement(TEAM_HEAD_DROPDOWN));
        // select.selectByVisibleText(teamHead);
        System.out.println("Unable to select team head due to missing locator");
    }

    public void clickSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(SAVE_BUTTON)).click();
    }

    public void verifyTeamCreation() {
        // Implement verification logic here
        // For example, check for a success message or the presence of the new team in a list
        System.out.println("Team creation verification not implemented");
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}