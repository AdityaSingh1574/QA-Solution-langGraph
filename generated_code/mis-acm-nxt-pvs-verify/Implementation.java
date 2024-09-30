package implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.List;
import org.junit.Assert;

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/form/div[3]/input"))).sendKeys(username);
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/form/div[4]/input")).sendKeys(password);
    }

    public void clickSigninButton() {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/form/div[5]/div[2]/input")).click();
    }

    public void verifyMISHomepage() {
        wait.until(ExpectedConditions.urlContains("mymis.geminisolutions.com"));
    }

    public void navigateToManageAccessCard(String dropdown, String option) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/nav/div/div[1]/ul/li[14]/span"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/nav/div/div[1]/ul/li[14]/ul/li[1]/a"))).click();
    }

    public void verifyEntriesChange(String expectedEntries, String selectedEntries) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[1]/section/div/div[2]/section/div/div/div/div[1]/label/select")));
        dropdown.click();
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/section/div/div[2]/section/div/div/div/div[1]/label/select/option[2]")).click();
        // Add verification logic here
    }

    public void verifyNextButtonWorks(String buttonText) {
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[1]/section/div/div[2]/section/div/div/div/div[5]/ul/li[9]/a")));
        nextButton.click();
        // Add verification logic here
    }

    public void verifyPreviousButtonWorks(String buttonText) {
        WebElement previousButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[1]/section/div/div[2]/section/div/div/div/div[5]/ul/li[1]/a")));
        previousButton.click();
        // Add verification logic here
    }

    public void verifyRecordCount(int expectedCount) {
        List<WebElement> records = driver.findElements(By.xpath("//table[@id='example1']/tbody/tr"));
        Assert.assertEquals("Number of records does not match", expectedCount, records.size());
    }

    public void verifyPageNavigation() {
        // Implement logic to verify page navigation
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}