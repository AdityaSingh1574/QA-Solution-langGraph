package implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import LNSALocators;

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(LNSALocators.USERNAME_INPUT)).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(LNSALocators.PASSWORD_INPUT).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(LNSALocators.LOGIN_BUTTON).click();
    }

    public void navigateToApplyLNSA() {
        wait.until(ExpectedConditions.elementToBeClickable(LNSALocators.APPLY_LNSA_LINK)).click();
    }

    public void checkWeekForLNSA(int weekNumber) {
        if (weekNumber == 40) {
            driver.findElement(LNSALocators.WEEK_40_CHECKBOX).click();
        } else if (weekNumber == 41) {
            driver.findElement(LNSALocators.WEEK_41_CHECKBOX).click();
        }
    }

    public void clickSubmitButton() {
        driver.findElement(LNSALocators.SUBMIT_BUTTON).click();
    }

    public void verifyLNSAApplicationPage() {
        // Implementation depends on the actual page structure
        // This is a placeholder
        wait.until(ExpectedConditions.urlContains("LNSAApplication"));
    }

    public void enterReason(String reason) {
        // Implementation depends on the actual page structure
        // This is a placeholder as REASON_INPUT locator is null in the provided locators
        // wait.until(ExpectedConditions.visibilityOfElementLocated(LNSALocators.REASON_INPUT)).sendKeys(reason);
    }

    public void clickFinalSubmitButton() {
        // Implementation depends on the actual page structure
        // This is a placeholder as FINAL_SUBMIT_BUTTON locator is null in the provided locators
        // driver.findElement(LNSALocators.FINAL_SUBMIT_BUTTON).click();
    }

    public void verifyLNSASubmissionSuccess() {
        // Implementation depends on the actual page structure
        // This is a placeholder
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'LNSA application submitted successfully')]")));
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}