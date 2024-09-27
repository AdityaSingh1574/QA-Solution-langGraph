package implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void clickExportTestDataButton() {
        WebElement exportButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/athena-root/div/athena-layout/div/div[2]/div/athena-test-control/p-tabview/div/div/p-tabpanel[1]/div/athena-placement-drives/div/div/div/div[1]/div[2]/button")));
        exportButton.click();
    }

    public boolean isDownloadButtonVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Download')]")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickDownloadButton() {
        WebElement downloadButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Download')]")));
        downloadButton.click();
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}