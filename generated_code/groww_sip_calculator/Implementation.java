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

    public void enterMonthlyInvestment(String amount) {
        WebElement monthlyInvestmentField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MONTHLY_INVESTMENT\"]")));
        monthlyInvestmentField.clear();
        monthlyInvestmentField.sendKeys(amount);
    }

    public void enterTimePeriod(String years) {
        WebElement timePeriodField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"TIME_PERIOD\"]")));
        timePeriodField.clear();
        timePeriodField.sendKeys(years);
    }

    public void enterExpectedReturnRate(String rate) {
        WebElement returnRateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"RETURN_RATE\"]")));
        returnRateField.clear();
        returnRateField.sendKeys(rate);
    }

    public boolean areFutureValuesDisplayed() {
        WebElement investmentAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[2]/span/span")));
        WebElement estReturns = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[4]/div[2]/div[2]/span/span")));
        WebElement totalValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[4]/div[3]/div[2]/span/span")));

        return investmentAmount.isDisplayed() && estReturns.isDisplayed() && totalValue.isDisplayed();
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}