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
        // Implement logic to verify homepage
        // This could be checking for a specific element on the homepage
    }

    public void navigateToInvoicePortal() {
        WebElement invoicePortalElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.invoicePortalLink));
        invoicePortalElement.click();
    }

    public void verifyInvoicePortalPage() {
        // Implement logic to verify invoice portal page
    }

    public void clickAddNewClientButton() {
        WebElement addNewClientElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.addNewClientButton));
        addNewClientElement.click();
    }

    public void enterClientName(String clientName) {
        // Note: The XPath for clientNameInput is not provided in the locators
        // You may need to identify and update this locator
        WebElement clientNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.clientNameInput));
        clientNameElement.sendKeys(clientName);
    }

    public void clickSaveButton() {
        // Note: The XPath for saveButton is not provided in the locators
        // You may need to identify and update this locator
        WebElement saveButtonElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.saveButton));
        saveButtonElement.click();
    }

    public void verifyInvoiceReportPage() {
        // Implement logic to verify invoice report page
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}