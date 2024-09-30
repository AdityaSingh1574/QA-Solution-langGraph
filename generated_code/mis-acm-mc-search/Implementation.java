package implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import static org.junit.Assert.*;
import AccessCardLocators;

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

    public void enterCredentials(String username, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AccessCardLocators.USERNAME_INPUT)).sendKeys(username);
        driver.findElement(AccessCardLocators.PASSWORD_INPUT).sendKeys(password);
    }

    public void clickSigninButton() {
        driver.findElement(AccessCardLocators.SIGN_IN_BUTTON).click();
    }

    public void verifyMISHomepage() {
        wait.until(ExpectedConditions.urlContains("mymis.geminisolutions.com"));
    }

    public void navigateToManageAccessCard(String menu, String submenu) {
        wait.until(ExpectedConditions.elementToBeClickable(AccessCardLocators.ACCESS_CARD_MANAGEMENT_DROPDOWN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(AccessCardLocators.MANAGE_CARD_ACCESS)).click();
    }

    public void verifyManageAccessCardPage(String pageName) {
        wait.until(ExpectedConditions.urlContains("manage-access-card"));
        assertTrue(driver.getTitle().contains(pageName));
    }

    public void searchForCardNumber(String cardNumber) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AccessCardLocators.SEARCH_INPUT)).sendKeys(cardNumber);
    }

    public void verifySearchResults(String cardNumber) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(AccessCardLocators.FIRST_SEARCH_RESULT, cardNumber));
    }

    public void verifySearchResultsAccuracy(String cardNumber) {
        String actualCardNumber = driver.findElement(AccessCardLocators.FIRST_SEARCH_RESULT).getText();
        assertEquals(cardNumber, actualCardNumber);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}