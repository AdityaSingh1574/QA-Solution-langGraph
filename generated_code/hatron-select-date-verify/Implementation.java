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

    public void selectEmailOption() {
        WebElement loginOptionDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/athena-root/div/athena-auth/athena-login/form/div/div[1]/div[2]/div[1]/div/div/p-dropdown")));
        loginOptionDropdown.click();
        WebElement emailOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/athena-root/div/athena-auth/athena-login/form/div/div[1]/div[2]/div[1]/div/div/p-dropdown/div/div[3]/div/ul/p-dropdownitem[1]")));
        emailOption.click();
    }

    public void enterEmail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/athena-root/div/athena-auth/athena-login/form/div/div[1]/div[2]/div[2]/div/div/input")));
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/athena-root/div/athena-auth/athena-login/form/div/div[1]/div[2]/div[2]/div/div/input")));
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/athena-root/div/athena-auth/athena-login/form/div/div[1]/div[2]/div[4]/button")));
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

    public void clickStartDateSelectionButton() {
        WebElement startDateButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/div/div/div/p-table/div/div[1]/div/div[2]/span/p-calendar/span/button")));
        startDateButton.click();
    }

    public void selectStartDate() {
        WebElement startDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div/div[2]/table/tbody/tr[1]/td[1]")));
        startDate.click();
    }

    public void clickEndDateSelectionButton() {
        WebElement endDateButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/div/div/div/p-table/div/div[1]/div/div[3]/span/p-calendar/span/button")));
        endDateButton.click();
    }

    public void selectEndDate() {
        WebElement endDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div/div[2]/table/tbody/tr[5]/td[2]")));
        endDate.click();
    }

    public boolean verifyFilteredRecords() {
        WebElement courseCounter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/div/div/div/div[2]/div[1]/span")));
        return courseCounter.isDisplayed();
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}