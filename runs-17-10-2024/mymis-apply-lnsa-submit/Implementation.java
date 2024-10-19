package implementation;

import locators.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class Implementation {
    private WebDriver driver;
    private WebDriverWait wait;

    public Implementation() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void launchUrl(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void enterUsername(String username) {
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.usernameInput));
        usernameElement.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.passwordInput));
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.loginButton));
        loginButtonElement.click();
    }

    public void verifyHomepage() {
        // Implement logic to verify homepage
        // This could be checking for a specific element on the homepage
    }

    public void navigateToLNSAApplyPage() {
        WebElement applyLnsaElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.applyLnsaLink));
        applyLnsaElement.click();
    }

    public void verifyLNSAApplyPage() {
        // Implement logic to verify LNSA Apply page
        // This could be checking for a specific element on the LNSA Apply page
    }

    public void checkWeekCheckbox(int weekNumber) {
        WebElement weekCheckbox;
        if (weekNumber == 40) {
            weekCheckbox = wait.until(ExpectedConditions.elementToBeClickable(Locators.week40Checkbox));
        } else if (weekNumber == 41) {
            weekCheckbox = wait.until(ExpectedConditions.elementToBeClickable(Locators.week41Checkbox));
        } else {
            throw new IllegalArgumentException("Unsupported week number: " + weekNumber);
        }
        weekCheckbox.click();
    }

    public void clickSubmitButton() {
        WebElement submitButtonElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.submitButton));
        submitButtonElement.click();
    }

    public void enterReason(String reason) {
        // Note: The locator for reasonInput is null in the provided Locators class
        // You may need to update the Locators class with the correct locator
        if (Locators.reasonInput != null) {
            WebElement reasonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.reasonInput));
            reasonElement.sendKeys(reason);
        } else {
            System.out.println("Warning: reasonInput locator is null. Unable to enter reason.");
        }
    }

    public void clickFinalSubmitButton() {
        // Note: The locator for finalSubmitButton is null in the provided Locators class
        // You may need to update the Locators class with the correct locator
        if (Locators.finalSubmitButton != null) {
            WebElement finalSubmitButtonElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.finalSubmitButton));
            finalSubmitButtonElement.click();
        } else {
            System.out.println("Warning: finalSubmitButton locator is null. Unable to click final submit button.");
        }
    }

    public void verifyLNSASubmission() {
        // Implement logic to verify LNSA submission
        // This could be checking for a success message or a specific element indicating successful submission
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}