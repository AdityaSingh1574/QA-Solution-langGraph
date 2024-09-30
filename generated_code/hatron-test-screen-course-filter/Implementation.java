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

    public void selectEmailLoginOption() {
        WebElement loginOptionDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/athena-root/div/athena-auth/athena-login/form/div/div[1]/div[2]/div[1]/div/div/p-dropdown")));
        loginOptionDropdown.click();
        WebElement emailOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/athena-root/div/athena-auth/athena-login/form/div/div[1]/div[2]/div[1]/div/div/p-dropdown/div/div[3]/div/ul/p-dropdownitem[1]")));
        emailOption.click();
    }

    public void enterEmail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/athena-root/div/athena-auth/athena-login/form/div/div[1]/div[2]/div[2]/div/div/input")));
        emailInput.sendKeys(email);
    }

    public void enterPasswordAndLogin(String password) {
        WebElement passwordInput = driver.findElement(By.xpath("/html/body/athena-root/div/athena-auth/athena-login/form/div/div[1]/div[2]/div[2]/div/div/input"));
        passwordInput.sendKeys(password);
        WebElement loginButton = driver.findElement(By.xpath("/html/body/athena-root/div/athena-auth/athena-login/form/div/div[1]/div[2]/div[4]/button"));
        loginButton.click();
    }

    public void clickHamburgerButton() {
        WebElement hamburgerButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/athena-root/div/athena-layout/div/div[1]/athena-header/p-toolbar/div/div[1]/em")));
        hamburgerButton.click();
    }

    public void clickTestsDropdown() {
        WebElement testsDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/athena-root/div/athena-layout/div/div[2]/div[1]/athena-sidemenu/p-sidebar/div/div[2]/p-panelmenu/div/div[2]/div[1]/a")));
        testsDropdown.click();
    }

    public void selectTestControls() {
        WebElement testControlsOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/athena-root/div/athena-layout/div/div[2]/div[1]/athena-sidemenu/p-sidebar/div/div[2]/p-panelmenu/div/div[2]/div[2]/div/p-panelmenusub/ul/li[1]/a")));
        testControlsOption.click();
    }

    public void filterCourseBy(String course) {
        WebElement courseDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/div/div/div/p-table/div/div[1]/div/div[1]/span/p-dropdown/div/span")));
        courseDropdown.click();
        WebElement courseOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/div/div/div/p-table/div/div[1]/div/div[1]/span/p-dropdown/div/div[3]/div[2]/ul/p-dropdownitem[contains(., '%s')]/li", course))));
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