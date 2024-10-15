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

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.usernameInput)).sendKeys(username);
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

    public void navigateToManagePolicyPage() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.managePoliciesLink)).click();
    }

    public void verifyCurrentUrl(String expectedUrl) {
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }

    public void clickViewPolicyButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.viewPolicyButton)).click();
    }

    public void clickDeactivatePolicyButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.deactivatePolicyButton)).click();
    }

    public void clickConfirmYesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.confirmYesButton)).click();
    }

    public void clickDeletePolicyButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.deletePolicyButton)).click();
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}