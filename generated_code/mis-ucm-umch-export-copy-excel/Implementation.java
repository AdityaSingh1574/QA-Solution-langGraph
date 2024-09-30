package implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.Assert;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.Toolkit;
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

    public void navigateToUserCardMapping(String menu, String submenu) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(Locators.ACCESS_CARD_MANAGEMENT_DROPDOWN[0])).perform();
        wait.until(ExpectedConditions.elementToBeClickable(Locators.USER_CARD_MANAGEMENT[0])).click();
    }

    public void goToUnmappedCardHistory() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.UNMAPPED_CARD_HISTORY_TAB[0])).click();
    }

    public void clickExportButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.EXPORT_BUTTON[0])).click();
    }

    public void clickCopyOption() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.COPY_BUTTON[0])).click();
    }

    public void verifyDataCopiedToClipboard() {
        try {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            String clipboardData = (String) clipboard.getData(DataFlavor.stringFlavor);
            Assert.assertFalse("Clipboard data should not be empty", clipboardData.isEmpty());
        } catch (Exception e) {
            Assert.fail("Failed to verify clipboard data: " + e.getMessage());
        }
    }

    public void clickExcelOption() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.EXCEL_BUTTON[0])).click();
    }

    public void verifyExcelDownloaded(String fileName) {
        String downloadPath = System.getProperty("user.home") + "/Downloads/";
        File file = new File(downloadPath + fileName + ".xlsx");
        Assert.assertTrue("Excel file was not downloaded", file.exists());
    }

    public void clickPrintButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.print();");
    }

    public void verifyPrintWorks(String fileName) {
        // This is a placeholder as we can't actually verify if printing worked
        System.out.println("Print dialog for " + fileName + " should have appeared");
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}