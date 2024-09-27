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

    public void clickOnActions() {
        WebElement actionButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"font-size\"]/athena-action/p-button/button")));
        actionButton.click();
    }

    public boolean verifyActionMenuItemExists(String menuItem) {
        String xpath = "";
        switch (menuItem) {
            case "Candidate Report":
                xpath = "//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/div/div/div/p-table/div[2]/div/div[1]";
                break;
            case "Test Summary":
                xpath = "//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/div/div/div/p-table/div[2]/div/div[2]";
                break;
            case "Evaluate Candidate":
                // No XPath provided for this item, return false
                return false;
        }
        WebElement menuItemElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        return menuItemElement.isDisplayed();
    }

    public void clickOnMenuItem(String menuItem) {
        String xpath = "";
        switch (menuItem) {
            case "Candidate Report":
                xpath = "//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/div/div/div/p-table/div[2]/div/div[1]";
                break;
            case "Test Summary":
                xpath = "//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/div/div/div/p-table/div[2]/div/div[2]";
                break;
            case "Evaluate Candidate":
                // No XPath provided for this item, do nothing
                return;
        }
        WebElement menuItemElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        menuItemElement.click();
    }

    public boolean verifyNavigation(String destination) {
        // This is a placeholder. In a real implementation, you would check for elements
        // specific to the destination page to verify navigation.
        return driver.getTitle().contains(destination);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}