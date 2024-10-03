package implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.io.File;

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_INPUT[0])).sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON[0])).click();
    }

    public void navigateToMenuItem(String menuItem) {
        wait.until(ExpectedConditions.elementToBeClickable(ACCESS_CARD_MANAGEMENT_SPAN[0])).click();
    }

    public void clickSubMenuItem(String subMenuItem) {
        wait.until(ExpectedConditions.elementToBeClickable(USER_CARD_MAPPING_LINK[0])).click();
    }

    public void verifyUserCardMappingPage() {
        // Add verification logic here
    }

    public void clickExportButton() {
        wait.until(ExpectedConditions.elementToBeClickable(EXPORT_BUTTON[0])).click();
    }

    public void clickCopyOption() {
        // Implementation not possible due to missing locator
        System.out.println("Copy option locator is missing");
    }

    public void clickExcelOption() {
        // Implementation not possible due to missing locator
        System.out.println("Excel option locator is missing");
    }

    public void verifyExcelFileDownloaded(String fileName) {
        // Add file download verification logic here
    }

    public void clickPrintButton() {
        // Implementation not possible due to missing locator
        System.out.println("Print button locator is missing");
    }

    public void verifyPrintWorksCorrectly(String fileName) {
        // Add print verification logic here
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}