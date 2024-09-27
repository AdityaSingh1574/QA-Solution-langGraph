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

    public void clickActionsButton() {
        WebElement actionsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"font-size\"]/athena-action/p-button/button")));
        actionsButton.click();
    }

    public boolean verifyActionMenuOption(String option) {
        String xpath = "";
        switch (option) {
            case "Candidate Report":
                xpath = "//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/div/div/div/p-table/div[2]/div/div[1]";
                break;
            case "Test Summary":
                xpath = "//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/div/div/div/p-table/div[2]/div/div[2]";
                break;
            case "Evaluate Candidate":
                // As there's no XPath provided for this option, we'll return false
                return false;
        }
        WebElement menuOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return menuOption.isDisplayed();
    }

    public void clickActionMenuOption(String option) {
        String xpath = "";
        switch (option) {
            case "Candidate Report":
                xpath = "//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/div/div/div/p-table/div[2]/div/div[1]";
                break;
            case "Test Summary":
                xpath = "//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/div/div/div/p-table/div[2]/div/div[2]";
                break;
            case "Evaluate Candidate":
                // As there's no XPath provided for this option, we'll do nothing
                return;
        }
        WebElement menuOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        menuOption.click();
    }

    public boolean verifyNavigation(String destination) {
        // This is a placeholder. In a real implementation, you would check for elements
        // specific to each destination page to verify navigation.
        return driver.getTitle().contains(destination);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}