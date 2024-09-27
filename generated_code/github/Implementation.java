package generated_code.github;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    public void clickSearchButton() {
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[1]/header/div/div[2]/div[1]/qbsearch-input/div[1]/div[1]/div/div/button")));
        searchButton.click();
    }

    public void enterSearchQuery(String query) {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"query-builder-test\"]")));
        searchInput.sendKeys(query);
    }

    public void pressEnterToSearch() {
        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"query-builder-test\"]"));
        searchInput.sendKeys(Keys.ENTER);
    }

    public void verifyResultsPage() {
        wait.until(ExpectedConditions.urlContains("search?q="));
    }

    public void printFirstThreeRepoNames() {
        WebElement firstRepo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[5]/main/react-app/div/div/div[1]/div/div/div[2]/div[2]/div/div[1]/div[4]/div/div/div[1]/div/div[1]/h3/div/div[2]/a/span")));
        WebElement secondRepo = driver.findElement(By.xpath("/html/body/div[1]/div[5]/main/react-app/div/div/div[1]/div/div/div[2]/div[2]/div/div[1]/div[4]/div/div/div[2]/div/div[1]/h3/div/div[2]/a/span"));
        WebElement thirdRepo = driver.findElement(By.xpath("/html/body/div[1]/div[5]/main/react-app/div/div/div[1]/div/div/div[2]/div[2]/div/div[1]/div[4]/div/div/div[3]/div/div[1]/h3/div/div[2]/a/span"));

        System.out.println("First repository: " + firstRepo.getText());
        System.out.println("Second repository: " + secondRepo.getText());
        System.out.println("Third repository: " + thirdRepo.getText());
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}