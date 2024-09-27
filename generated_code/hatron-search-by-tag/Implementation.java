package implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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

    public void enterSearchText(String searchText) {
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/div/div/div/p-table/div/div[1]/div/div[4]/span/input")));
        searchInput.clear();
        searchInput.sendKeys(searchText);
    }

    public int getFilteredCourseCount() {
        WebElement courseCounter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/div/div/div/div[2]/div[1]/span")));
        String countText = courseCounter.getText();
        return Integer.parseInt(countText.split(" ")[0]);
    }

    public boolean verifyFilteredResults(String expectedCourse) {
        List<WebElement> courseElements = driver.findElements(By.xpath("//table//tr/td[1]")); // Assuming course names are in the first column
        for (WebElement element : courseElements) {
            if (!element.getText().contains(expectedCourse)) {
                return false;
            }
        }
        return true;
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}