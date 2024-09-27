package implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public void clickOnNameSection() {
        WebElement nameSection = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/athena-root/div/athena-layout/div/div[2]/div/athena-test-control/p-tabview/div/div/p-tabpanel[1]/div/athena-placement-drives/div/div/div/p-table/div/div[2]/table/thead/tr/th[1]")));
        nameSection.click();
    }

    public void verifySortingAndPrintNames() {
        List<String> names = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            String xpath = String.format("/html/body/athena-root/div/athena-layout/div/div[2]/div/athena-test-control/p-tabview/div/div/p-tabpanel[1]/div/athena-placement-drives/div/div/div/p-table/div/div[2]/table/tbody/tr[%d]/td[1]", i);
            WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            names.add(nameElement.getText());
        }

        List<String> sortedNames = new ArrayList<>(names);
        Collections.sort(sortedNames);

        System.out.println("First 3 Names:");
        for (String name : names) {
            System.out.println(name);
        }

        if (names.equals(sortedNames)) {
            System.out.println("Names are sorted in increasing order.");
        } else {
            System.out.println("Names are not sorted in increasing order.");
        }
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}