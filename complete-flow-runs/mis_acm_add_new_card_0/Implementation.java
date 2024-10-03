package implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.io.File;

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.USERNAME_INPUT)).sendKeys(userId);
    }

    public void enterPassword(String password) {
        driver.findElement(Locators.PASSWORD_INPUT).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(Locators.LOGIN_BUTTON).click();
    }

    public void verifyHomepage() {
        // Add logic to verify the homepage
        // For example, check for a specific element that exists only on the homepage
    }

    public void clickExportButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.EXPORT_BUTTON)).click();
    }

    public void clickCopyOption() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.COPY_OPTION)).click();
    }

    public void clickExcelOption() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.EXCEL_OPTION)).click();
    }

    public void verifyExcelFileDownload(String fileName) {
        // Add logic to verify if the Excel file is downloaded
        // For example, check if the file exists in the downloads folder
        String userHome = System.getProperty("user.home");
        String downloadPath = userHome + "/Downloads/" + fileName + ".xlsx";
        File file = new File(downloadPath);
        // Wait for the file to be downloaded (you might need to adjust the time)
        wait.until(driver -> file.exists());
    }

    public void clickPrintButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.PRINT_BUTTON)).click();
    }

    public void verifyPrintFunctionality(String documentName) {
        // Add logic to verify if the print functionality works correctly
        // This might involve checking for a print preview or a print dialog
        // Note: Verifying actual printing might be challenging in an automated test
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}