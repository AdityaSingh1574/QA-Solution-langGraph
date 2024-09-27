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
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"product-2\"]")));
        product.click();
    }

    public void verifyProductPage() {
        wait.until(ExpectedConditions.urlContains("product"));
    }

    public void clickAddToCart() {
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"add\"]")));
        addToCartButton.click();
    }

    public void clickCartIcon() {
        WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"minicart\"]/a[2]")));
        cartIcon.click();
    }

    public String getFirstItemNameInCart() {
        WebElement firstItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cart\"]/form/div[1]/div[2]/div[1]/div/h3/a")));
        return firstItem.getText();
    }

    public void verifyFirstItemInCart(String expectedItemName) {
        String actualItemName = getFirstItemNameInCart();
        assert actualItemName.equals(expectedItemName) : "Expected item: " + expectedItemName + ", but found: " + actualItemName;
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}