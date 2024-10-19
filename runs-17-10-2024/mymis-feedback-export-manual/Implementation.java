package implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;
import static org.junit.Assert.assertEquals;
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
        wait.until(ExpectedConditions.elementToBeClickable(Locators.loginButton));
        driver.findElement(Locators.loginButton).click();
    }

    public void navigateToQuarterlyFeedback() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.quarterlyFeedbackLink));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.quarterlyFeedbackLink));
        driver.findElement(Locators.quarterlyFeedbackLink).click();
    }

    public void selectFirstFinancialYear() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.financialYearDropdown));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.financialYearDropdown));
        Select dropdown = new Select(driver.findElement(Locators.financialYearDropdown));
        dropdown.selectByIndex(1);
    }

    public void selectFinadvisorFromDeliveryCouncil() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.deliveryCouncilDropdown));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.deliveryCouncilDropdown));
        Select dropdown = new Select(driver.findElement(Locators.deliveryCouncilDropdown));
        dropdown.selectByVisibleText("Finadvisor");
    }

    public void changeNumberOfEntries(int entries) {
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.entriesDropdown));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.entriesDropdown));
        Select dropdown = new Select(driver.findElement(Locators.entriesDropdown));
        dropdown.selectByValue(String.valueOf(entries));
    }

    public void clickExportButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.exportLink));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.exportLink));
        driver.findElement(Locators.exportLink).click();
    }

    public void clickUserManualButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(Locators.userManualLink));
        wait.until(ExpectedConditions.elementToBeClickable(Locators.userManualLink));
        driver.findElement(Locators.userManualLink).click();
    }

    public void verifyRedirection(String expectedUrl) {
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}