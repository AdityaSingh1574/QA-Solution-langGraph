package implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class Implementation {
    private WebDriver driver;
    private WebDriverWait wait;

    public void launchUrl() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://mymis.geminisolutions.com/");
    }

    public void login() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.LoginPageLocators.USERNAME_INPUT));
        driver.findElement(Locators.LoginPageLocators.USERNAME_INPUT).sendKeys("your_username");
        driver.findElement(Locators.LoginPageLocators.PASSWORD_INPUT).sendKeys("your_password");
        driver.findElement(Locators.LoginPageLocators.SIGN_IN_BUTTON).click();
        // Wait for login to complete
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.NavigationLocators.ACCESS_CARD_MANAGEMENT_DROPDOWN));
    }

    public void navigateToMenu(String menu1, String menu2) {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.NavigationLocators.ACCESS_CARD_MANAGEMENT_DROPDOWN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Locators.NavigationLocators.USER_CARD_MANAGEMENT_OPTION)).click();
    }

    public void enterSearchTerm(String searchTerm) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.UserCardManagementLocators.SEARCH_INPUT));
        driver.findElement(Locators.UserCardManagementLocators.SEARCH_INPUT).sendKeys(searchTerm);
    }

    public void verifySearchResultsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.UserCardManagementLocators.FIRST_SEARCH_RESULT_NAME));
        Assert.assertTrue("Search results are not displayed", driver.findElement(Locators.UserCardManagementLocators.FIRST_SEARCH_RESULT_NAME).isDisplayed());
    }

    public void verifyFirstResultName(String expectedName) {
        String actualName = driver.findElement(Locators.UserCardManagementLocators.FIRST_SEARCH_RESULT_NAME).getText();
        Assert.assertTrue("First result does not contain expected name", actualName.contains(expectedName));
    }

    public void verifySearchFunctionality(String searchTerm) {
        verifySearchResultsDisplayed();
        verifyFirstResultName(searchTerm);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}