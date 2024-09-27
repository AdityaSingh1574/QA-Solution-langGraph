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

    public void navigateToTestControlScreen() {
        // Implement navigation to TestControl screen
        // This is a placeholder as the exact navigation is not provided
    }

    public void filterCourse(String course) {
        WebElement courseDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/div/div/div/p-table/div/div[1]/div/div[1]/span/p-dropdown/div/span")));
        courseDropdown.click();

        String optionXpath = "";
        switch (course) {
            case "HTET":
                optionXpath = "//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/div/div/div/p-table/div/div[1]/div/div[1]/span/p-dropdown/div/div[3]/div[2]/ul/p-dropdownitem[2]/li";
                break;
            case "HSSC":
                optionXpath = "//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/div/div/div/p-table/div/div[1]/div/div[1]/span/p-dropdown/div/div[3]/div[2]/ul/p-dropdownitem[3]/li";
                break;
            case "HPSC":
                // Assuming HPSC is the next option, adjust if needed
                optionXpath = "//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/div/div/div/p-table/div/div[1]/div/div[1]/span/p-dropdown/div/div[3]/div[2]/ul/p-dropdownitem[4]/li";
                break;
        }

        WebElement courseOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(optionXpath)));
        courseOption.click();
    }

    public String getRecordsCount() {
        WebElement recordsCounter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/div/div/div/div[2]/div[1]/span")));
        return recordsCounter.getText();
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}