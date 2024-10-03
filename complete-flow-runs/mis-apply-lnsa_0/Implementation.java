package implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import Locators.LoginPageLocators;
import Locators.LNSAPageLocators;

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.USERNAME_INPUT)).sendKeys(userId);
    }

    public void enterPassword(String password) {
        driver.findElement(LoginPageLocators.PASSWORD_INPUT).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(LoginPageLocators.LOGIN_BUTTON).click();
    }

    public void verifyHomepage() {
        // Add verification logic for homepage
        wait.until(ExpectedConditions.urlContains("mymis.geminisolutions.com"));
    }

    public void navigateToLNSAApply() {
        wait.until(ExpectedConditions.elementToBeClickable(LNSAPageLocators.APPLY_LNSA_LINK)).click();
    }

    public void verifyLNSAApplyPage() {
        // Add verification logic for LNSA Apply page
        wait.until(ExpectedConditions.urlContains("Lnsa/Apply"));
    }

    public void checkWeekCheckbox(Integer weekNumber) {
        if (weekNumber == 40) {
            driver.findElement(LNSAPageLocators.WEEK_40_CHECKBOX).click();
        } else if (weekNumber == 41) {
            driver.findElement(LNSAPageLocators.WEEK_41_CHECKBOX).click();
        }
    }

    public void clickSubmitButton() {
        driver.findElement(LNSAPageLocators.SUBMIT_BUTTON).click();
    }

    public void enterReason(String reason) {
        // Note: The REASON_INPUT locator is null in the provided Locators file
        // You may need to update this method once the correct locator is available
        if (LNSAPageLocators.REASON_INPUT != null) {
            driver.findElement(LNSAPageLocators.REASON_INPUT).sendKeys(reason);
        }
    }

    public void clickFinalSubmitButton() {
        // Note: The FINAL_SUBMIT_BUTTON locator is null in the provided Locators file
        // You may need to update this method once the correct locator is available
        if (LNSAPageLocators.FINAL_SUBMIT_BUTTON != null) {
            driver.findElement(LNSAPageLocators.FINAL_SUBMIT_BUTTON).click();
        }
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}