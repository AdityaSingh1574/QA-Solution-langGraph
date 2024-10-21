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

    public void verifyDashboardRedirection() {
        // Implement dashboard verification logic
    }

    public void navigateToMealManagement() {
        WebElement manageElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.manageLink));
        manageElement.click();
    }

    public void verifyMealManagementPage() {
        // Implement meal management page verification logic
    }

    public void clickAddMealPeriodButton() {
        WebElement addMealPeriodElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.addMealPeriodButton));
        addMealPeriodElement.click();
    }

    public void enterMealPeriod(String mealPeriod) {
        // Implement logic to enter meal period (dynamic locator handling required)
    }

    public void clickSaveMealPeriodButton() {
        WebElement saveMealPeriodElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.saveMealPeriodButton));
        saveMealPeriodElement.click();
    }

    public void clickAddMealTypeButton() {
        WebElement mealTypeTabElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.mealTypeTab));
        mealTypeTabElement.click();
        WebElement addMealTypeElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.addMealTypeButton));
        addMealTypeElement.click();
    }

    public void enterMealType(String mealType) {
        // Implement logic to enter meal type (dynamic locator handling required)
    }

    public void clickSaveMealTypeButton() {
        WebElement saveMealTypeElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.saveMealTypeButton));
        saveMealTypeElement.click();
    }

    public void clickAddMealCategoryButton() {
        WebElement mealCategoryTabElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.mealCategoryTab));
        mealCategoryTabElement.click();
        WebElement addMealCategoryElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.addMealCategoryButton));
        addMealCategoryElement.click();
    }

    public void enterMealCategory(String mealCategory) {
        // Implement logic to enter meal category (dynamic locator handling required)
    }

    public void clickSaveMealCategoryButton() {
        WebElement saveMealCategoryElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.saveMealCategoryButton));
        saveMealCategoryElement.click();
    }

    public void clickAddMealDishesButton() {
        WebElement mealDishesTabElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.mealDishesTab));
        mealDishesTabElement.click();
        WebElement addMealDishesElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.addMealDishesButton));
        addMealDishesElement.click();
    }

    public void enterMealDishes(String mealDishes) {
        // Implement logic to enter meal dishes (dynamic locator handling required)
    }

    public void clickSaveMealDishesButton() {
        WebElement saveMealDishesElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.saveMealDishesButton));
        saveMealDishesElement.click();
    }

    public void verifyMealManagementPageRedirection() {
        // Implement meal management page redirection verification logic
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}