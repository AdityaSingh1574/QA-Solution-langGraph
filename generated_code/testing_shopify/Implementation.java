package generated_code.testing_shopify;

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

    public void clickOnProduct(String productName) {
        String xpath = productName.toLowerCase().equals("noir jacket") ? "//*[@id=\"product-2\"]" : "/html/body/div[3]/div[2]/div/section/div[1]/a";
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        product.click();
    }

    public void verifyProductPage(String productName) {
        wait.until(ExpectedConditions.titleContains(productName));
    }

    public void clickAddToCart() {
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"add\"]")));
        addToCartButton.click();
    }

    public void verifyCartUpdate() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/header/div[1]/div[3]/div/a[2]")));
    }

    public void clickCartIcon() {
        WebElement cartIcon = driver.findElement(By.xpath("/html/body/header/div[1]/div[3]/div/a[2]"));
        cartIcon.click();
    }

    public void verifyCartSummaryPage() {
        wait.until(ExpectedConditions.urlContains("/cart"));
    }

    public void verifyFirstItemInCart() {
        WebElement firstItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[2]/div/section/form/div[1]/div[2]/div[1]/div/h3/a")));
        assert firstItem.isDisplayed();
    }

    public void verifyCartContents(String productName) {
        WebElement cartItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[2]/div/section/form/div[1]/div[2]/div[1]/div/h3/a")));
        assert cartItem.getText().contains(productName);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}