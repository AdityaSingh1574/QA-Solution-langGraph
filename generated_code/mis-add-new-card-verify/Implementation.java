package implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import static org.junit.Assert.assertTrue;
import static stepdefinitions.Locators.*;

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT[0])).sendKeys(username);
        driver.findElement(PASSWORD_INPUT[0]).sendKeys(password);
    }

    public void clickSignInButton() {
        driver.findElement(SIGN_IN_BUTTON[0]).click();
    }

    public void verifyMISHomepage() {
        // Add verification logic for MIS homepage
        assertTrue("MIS homepage not loaded", driver.getTitle().contains("MIS"));
    }

    public void navigateToAccessCardManagement() {
        wait.until(ExpectedConditions.elementToBeClickable(ACCESS_CARD_MANAGEMENT_DROPDOWN[0])).click();
        // Add logic to click on "Manage Access Card" submenu
    }

    public void clickAddNewCardButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ADD_NEW_CARD_BUTTON[0])).click();
    }

    public void enterCardNumber(String cardNumber) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(NEW_CARD_NUMBER_INPUT[0])).sendKeys(cardNumber);
    }

    public void toggleTemporaryCardOption() {
        driver.findElement(TEMP_CARD_CHECKBOX[0]).click();
    }

    public void clickAddButton() {
        driver.findElement(FINAL_ADD_BUTTON[0]).click();
    }

    public void verifyCardAdded() {
        // Add verification logic for card added successfully
        assertTrue("Card not added successfully", driver.getPageSource().contains("Card added successfully"));
    }

    public void verifyCardInList(String cardNumber) {
        // Add verification logic to check if the card appears in the list
        assertTrue("Card not found in the list", driver.getPageSource().contains(cardNumber));
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}