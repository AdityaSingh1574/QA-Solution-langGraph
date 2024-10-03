package implementations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import Locators.*;

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.USERNAME_INPUT)).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(LoginPageLocators.PASSWORD_INPUT).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(LoginPageLocators.LOGIN_BUTTON).click();
    }

    public void navigateToAccessCardManagement() {
        wait.until(ExpectedConditions.elementToBeClickable(AccessCardManagementLocators.ACCESS_CARD_MANAGEMENT_SPAN)).click();
    }

    public void clickManageAccessCard() {
        wait.until(ExpectedConditions.elementToBeClickable(AccessCardManagementLocators.MANAGE_ACCESS_CARD_LINK)).click();
    }

    public void selectRecordsPerPage(String number) {
        wait.until(ExpectedConditions.elementToBeClickable(PaginationLocators.RECORD_SELECTION_DROPDOWN)).click();
        driver.findElement(By.xpath("//a[contains(text(), '" + number + "')]")).click();
    }

    public void clickNextButton() {
        driver.findElement(PaginationLocators.NEXT_BUTTON).click();
    }

    public void clickPreviousButton() {
        driver.findElement(PaginationLocators.PREVIOUS_BUTTON).click();
    }

    public boolean isOnAccessCardManagementPage() {
        return driver.getCurrentUrl().contains("/AccessCard/Manage");
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}