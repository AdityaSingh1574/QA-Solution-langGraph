package implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.usernameInput));
        usernameElement.sendKeys(userId);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.passwordInput));
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.loginButton));
        loginButtonElement.click();
    }

    public void verifyHomepageRedirect() {
        // Implement logic to verify homepage redirect
        // This could involve checking for a specific element on the homepage
    }

    public void navigateToAppraisalCycle() {
        WebElement appraisalCycleElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.appraisalCycleLink));
        appraisalCycleElement.click();
    }

    public void clickAddNewButton() {
        WebElement addNewButtonElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.addNewButton));
        addNewButtonElement.click();
    }

    public void selectCountry(String country) {
        // Note: The locator for countryDropdown is null in the provided Locators class
        // You may need to update the Locators class with the correct locator
        if (Locators.countryDropdown != null) {
            WebElement countryDropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.countryDropdown));
            Select countrySelect = new Select(countryDropdownElement);
            countrySelect.selectByVisibleText(country);
        }
    }

    public void selectYear(String year) {
        // Note: The locator for yearDropdown is null in the provided Locators class
        // You may need to update the Locators class with the correct locator
        if (Locators.yearDropdown != null) {
            WebElement yearDropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.yearDropdown));
            Select yearSelect = new Select(yearDropdownElement);
            yearSelect.selectByVisibleText(year);
        }
    }

    public void selectMonth(String month) {
        // Note: The locator for monthDropdown is null in the provided Locators class
        // You may need to update the Locators class with the correct locator
        if (Locators.monthDropdown != null) {
            WebElement monthDropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.monthDropdown));
            Select monthSelect = new Select(monthDropdownElement);
            monthSelect.selectByVisibleText(month);
        }
    }

    public void clickSaveButton() {
        // Note: The locator for saveButton is null in the provided Locators class
        // You may need to update the Locators class with the correct locator
        if (Locators.saveButton != null) {
            WebElement saveButtonElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.saveButton));
            saveButtonElement.click();
        }
    }

    public void verifyAppraisalCyclePageRedirect() {
        // Implement logic to verify redirect to Appraisal Cycle page
        // This could involve checking for a specific element on the Appraisal Cycle page
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}