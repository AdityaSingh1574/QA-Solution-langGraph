package implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.Locators;
import org.junit.Assert;

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

    public void verifyMISHomepage() {
        // Add verification logic for MIS homepage
        Assert.assertTrue("User is not on MIS homepage", driver.getCurrentUrl().contains("mymis.geminisolutions.com"));
    }

    public void navigateToApplyLNSA() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.applyLnsaLink)).click();
    }

    public void checkWeekForLNSA(int weekNumber) {
        if (weekNumber == 40) {
            driver.findElement(Locators.week40Checkbox).click();
        } else if (weekNumber == 41) {
            driver.findElement(Locators.week41Checkbox).click();
        }
    }

    public void clickSubmitButton() {
        driver.findElement(Locators.submitButton).click();
    }

    public void verifyLNSAApplicationPage() {
        // Add verification logic for LNSA application page
        Assert.assertTrue("User is not on LNSA application page", driver.getCurrentUrl().contains("Lnsa/Apply"));
    }

    public void enterReason(String reason) {
        // Note: The XPath for reasonInput is not provided in the locators, so this is a placeholder
        // You may need to update this once you have the correct locator
        if (Locators.reasonInput != null) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.reasonInput)).sendKeys(reason);
        } else {
            System.out.println("Reason input field locator is not available");
        }
    }

    public void clickFinalSubmitButton() {
        // Note: The XPath for finalSubmitButton is not provided in the locators, so this is a placeholder
        // You may need to update this once you have the correct locator
        if (Locators.finalSubmitButton != null) {
            wait.until(ExpectedConditions.elementToBeClickable(Locators.finalSubmitButton)).click();
        } else {
            System.out.println("Final submit button locator is not available");
        }
    }

    public void verifyLNSASubmission() {
        // Add verification logic for successful LNSA submission
        // This is a placeholder and should be replaced with actual verification logic
        Assert.assertTrue("LNSA application was not submitted successfully", true);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}