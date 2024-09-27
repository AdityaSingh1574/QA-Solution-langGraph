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

    public void launchUrl() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://your-test-control-url.com"); // Replace with actual URL
    }

    public void clickStartDateButton() {
        WebElement startDateButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/div/div/div/p-table/div/div[1]/div/div[2]/span/p-calendar/span/button")));
        startDateButton.click();
    }

    public void selectStartDate() {
        WebElement startDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div/div[2]/table/tbody/tr[1]/td[1]")));
        startDate.click();
    }

    public void clickEndDateButton() {
        WebElement endDateButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/div/div/div/p-table/div/div[1]/div/div[3]/span/p-calendar/span/button")));
        endDateButton.click();
    }

    public void selectEndDate() {
        WebElement endDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div/div[2]/table/tbody/tr[5]/td[2]")));
        endDate.click();
    }

    public void verifyFilteredRecords() {
        // Implement logic to verify that records are filtered
        // This might involve checking if the table content has changed
    }

    public void verifyRecordsWithinDateRange() {
        // Implement logic to verify that displayed records are within the selected date range
        // This might involve parsing dates from the table and comparing them with selected range
    }

    public void verifyRecordCount() {
        WebElement courseCounter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/div/div/div/div[2]/div[1]/span")));
        assert courseCounter.isDisplayed() : "Course counter is not displayed";
        // You can add more assertions here to verify the count if needed
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}