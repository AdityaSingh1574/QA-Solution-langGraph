package implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

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

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.LoginPageLocators.USERNAME_INPUT))
            .sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(Locators.LoginPageLocators.PASSWORD_INPUT).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(Locators.LoginPageLocators.LOGIN_BUTTON).click();
    }

    public void verifySuccessfulLogin() {
        // Add verification logic here
        // For example, check if a dashboard element is present
        wait.until(ExpectedConditions.urlContains("Dashboard"));
    }

    public void navigateToMenuItem(String menuItem) {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.NavigationLocators.ACCESS_CARD_MANAGEMENT_SPAN))
            .click();
    }

    public void clickOnSubMenuItem(String subMenuItem) {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.NavigationLocators.USER_CARD_MAPPING_LINK))
            .click();
    }

    public void enterSearchText(String searchText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.UserCardMappingLocators.SEARCH_INPUT))
            .sendKeys(searchText);
    }

    public void pressEnterInSearchBar() {
        driver.findElement(Locators.UserCardMappingLocators.SEARCH_INPUT).sendKeys(Keys.ENTER);
    }

    public void verifySearchResults(String searchText) {
        // Add verification logic here
        // For example, check if the search results contain the searchText
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), searchText));
    }

    public void verifyRelevantInformation(String searchText) {
        // Add verification logic here
        // For example, check if specific information related to the searchText is present
        assertTrue(driver.getPageSource().contains(searchText));
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}