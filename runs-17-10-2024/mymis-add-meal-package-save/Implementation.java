package implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        // Add verification logic for homepage
        wait.until(ExpectedConditions.urlContains("Home"));
    }

    public void navigateToMealManagement() {
        WebElement mealManagementElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.mealManagementSpan));
        mealManagementElement.click();
    }

    public void clickMealPackageOption() {
        WebElement mealPackageElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.mealPackageLink));
        mealPackageElement.click();
    }

    public void verifyMealPackagePage() {
        // Add verification logic for Meal Package page
        wait.until(ExpectedConditions.urlContains("MealPackage"));
    }

    public void clickAddNewMealPackageButton() {
        WebElement addMealPackageElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.addMealPackageButton));
        addMealPackageElement.click();
    }

    public void selectMealPeriod(String mealPeriod) {
        WebElement mealPeriodElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.mealPeriodDropdown));
        mealPeriodElement.click();
        // Add logic to select the specific meal period
    }

    public void selectMealType(String mealType) {
        WebElement mealTypeElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.mealTypeDropdown));
        mealTypeElement.click();
        // Add logic to select the specific meal type
    }

    public void selectMealCategory(String mealCategory) {
        WebElement mealCategoryElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.mealCategoryDropdown));
        mealCategoryElement.click();
        // Add logic to select the specific meal category
    }

    public void clickSaveButton() {
        WebElement saveButtonElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.saveButton));
        saveButtonElement.click();
    }

    public void verifyMealPackageListingPage() {
        // Add verification logic for Meal Package listing page
        wait.until(ExpectedConditions.urlContains("MealPackage"));
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}