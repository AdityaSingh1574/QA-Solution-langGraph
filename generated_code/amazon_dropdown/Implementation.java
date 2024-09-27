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

    public void enterSearchTerm(String searchTerm) {
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"twotabsearchtextbox\"]")));
        searchBox.sendKeys(searchTerm);
    }

    public void clickSearchButton() {
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"nav-search-submit-button\"]")));
        searchButton.click();
    }

    public void verifySearchResults(String searchTerm) {
        wait.until(ExpectedConditions.titleContains(searchTerm));
    }

    public void printSearchResults() {
        List<WebElement> searchResults = driver.findElements(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[position()>=3 and position()<=7]/div/div/div/div/span/div/div/div[2]/div[2]/div[2]/h2/span"));
        for (WebElement result : searchResults) {
            System.out.println(result.getText());
        }
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}