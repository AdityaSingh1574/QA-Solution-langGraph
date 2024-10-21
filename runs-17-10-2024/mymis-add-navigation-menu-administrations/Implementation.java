package implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.Locators;

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

    public void enterUsername(String username) {
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.usernameInput));
        usernameElement.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.passwordInput));
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.loginButton));
        loginButtonElement.click();
    }

    public void verifyHomepage() {
        // Implement logic to verify homepage
    }

    public void navigateToManageMenu() {
        WebElement manageMenuElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.manageMenuLink));
        manageMenuElement.click();
    }

    public void verifyManageMenuPage() {
        // Implement logic to verify Manage Menu page
    }

    public void clickAddNewNavigationMenuButton() {
        WebElement addNavigationMenuButtonElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.addNavigationMenuButton));
        addNavigationMenuButtonElement.click();
    }

    public void enterMenuName(String menuName) {
        // Implement logic to enter menu name
    }

    public void enterActionName() {
        // Implement logic to enter action name
    }

    public void enterControllerName() {
        // Implement logic to enter controller name
    }

    public void enterCssClass() {
        // Implement logic to enter CSS class
    }

    public void enterMenuSequence() {
        // Implement logic to enter menu sequence
    }

    public void toggleSelectMenu() {
        // Implement logic to toggle select menu
    }

    public void selectIsLinkEnabled() {
        // Implement logic to select 'is link enabled'
    }

    public void selectIsDelegatable() {
        // Implement logic to select 'is delegatable'
    }

    public void clickAddNavigationMenuButton() {
        WebElement addNavigationMenuSubmitButtonElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.addNavigationMenuSubmitButton));
        addNavigationMenuSubmitButtonElement.click();
    }

    public void verifyRedirectionToManageMenuPage() {
        // Implement logic to verify redirection to Manage Menu page
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}