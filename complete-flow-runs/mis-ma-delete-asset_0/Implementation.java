package implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.openqa.selenium.Alert;

import static Locators.*;

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT[0])).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(PASSWORD_INPUT[0]).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON[0]).click();
    }

    public void navigateToManageAssetAllocation() {
        wait.until(ExpectedConditions.elementToBeClickable(MANAGE_ASSET_LINK[0])).click();
    }

    public void verifyAssetManagementPage() {
        wait.until(ExpectedConditions.urlContains("/Asset/Manage"));
    }

    public void clickDeleteAssetButton() {
        wait.until(ExpectedConditions.elementToBeClickable(DELETE_ASSET_BUTTON[0])).click();
    }

    public void confirmDeletion() {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
        } catch (Exception e) {
            System.out.println("No alert present, proceeding without confirmation.");
        }
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}