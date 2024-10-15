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
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.usernameInput)).sendKeys(userId);
    }

    public void enterPassword(String password) {
        driver.findElement(Locators.passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(Locators.loginButton).click();
    }

    public void verifyHomepage() {
        wait.until(ExpectedConditions.urlContains("mymis.geminisolutions.com"));
    }

    public void navigateToTeamInfo() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.teamInformationLink)).click();
    }

    public void verifyTeamManagementPage() {
        wait.until(ExpectedConditions.urlContains("TeamManagement/TeamInformation"));
    }

    public void clickViewTeam() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.viewTeamButton)).click();
    }

    public void clickDelete() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.deleteButton)).click();
    }

    public void confirmDeletion() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.confirmDeleteButton)).click();
    }

    public void verifyTeamInformationPage() {
        wait.until(ExpectedConditions.urlContains("TeamManagement/TeamInformation"));
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}