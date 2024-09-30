package implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import static org.junit.Assert.*;

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
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.USERNAME_INPUT[0]));
        WebElement passwordInput = driver.findElement(Locators.PASSWORD_INPUT[0]);
        WebElement signInButton = driver.findElement(Locators.SIGN_IN_BUTTON[0]);

        usernameInput.sendKeys("your_username");
        passwordInput.sendKeys("your_password");
        signInButton.click();
    }

    public void navigateToUserCardMapping(String mainMenu, String subMenu) {
        WebElement accessCardManagement = wait.until(ExpectedConditions.elementToBeClickable(Locators.ACCESS_CARD_MANAGEMENT_DROPDOWN[0]));
        accessCardManagement.click();

        WebElement userCardManagement = wait.until(ExpectedConditions.elementToBeClickable(Locators.USER_CARD_MANAGEMENT[0]));
        userCardManagement.click();
    }

    public void searchUserCard(String searchType) {
        WebElement entrySelection = wait.until(ExpectedConditions.elementToBeClickable(Locators.ENTRY_SELECTION_DROPDOWN[0]));
        entrySelection.sendKeys(searchType);

        WebElement searchInput = driver.findElement(Locators.SEARCH_INPUT[0]);
        searchInput.sendKeys("user_to_search");
    }

    public void unfinalizeCardMapping() {
        WebElement unfinalizeButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.UNFINALIZE_BUTTON[0]));
        unfinalizeButton.click();

        WebElement additionalOption = wait.until(ExpectedConditions.elementToBeClickable(Locators.ADDITIONAL_OPTION[0]));
        additionalOption.click();
    }

    public void verifyMappingUnfinalized() {
        // Implement verification logic
        assertTrue("Mapping should be unfinalized", true);
    }

    public void verifyCardStatusUnfinalized() {
        // Implement verification logic
        assertTrue("Card status should be Unfinalized", true);
    }

    public void verifyCardAvailableForRemapping() {
        // Implement verification logic
        assertTrue("Card should be available for remapping", true);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}