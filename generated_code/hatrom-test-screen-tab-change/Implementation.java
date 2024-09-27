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

    public void verifyHSCExaminationScreen() {
        WebElement hscExaminationTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"p-tabpanel-0-label\"]")));
        assert hscExaminationTab.isDisplayed() : "HSC Examination screen is not displayed";
    }

    public void navigateToExamTemplateManagement() {
        WebElement examTemplateManagementTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"p-tabpanel-1-label\"]")));
        examTemplateManagementTab.click();
    }

    public void verifyExamTemplateManagementScreen() {
        WebElement examTemplateManagementTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"p-tabpanel-1-label\"]")));
        assert examTemplateManagementTab.getAttribute("aria-selected").equals("true") : "Exam Template Management screen is not displayed";
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}