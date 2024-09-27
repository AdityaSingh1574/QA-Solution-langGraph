package implementation;

import org.openqa.selenium.By;
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

    public void launchUrl() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://your-test-control-url.com"); // Replace with actual URL
    }

    public void clickFirstTest() {
        WebElement firstTest = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"font-size\"]")));
        firstTest.click();
    }

    public void verifyTestDetailsScreen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/p-sidebar/div/div[2]/div[5]/span")));
    }

    public void printTestUrl() {
        WebElement testUrlSpan = driver.findElement(By.xpath("//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/p-sidebar/div/div[2]/div[5]/span"));
        String testUrl = testUrlSpan.getText();
        System.out.println("Test URL: " + testUrl);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}