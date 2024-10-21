package implementation;

import locators.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;
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

    public void enterUserId(String userId) {
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.usernameInput));
        usernameElement.sendKeys(userId);
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
        // For example, check for a specific element on the homepage
    }

    public void navigateToParameterMaster() {
        WebElement appraisalManagementElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.appraisalManagementSpan));
        appraisalManagementElement.click();
        WebElement parameterMasterElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.parameterMasterLink));
        parameterMasterElement.click();
    }

    public void verifyParameterMasterPage() {
        // Implement logic to verify Parameter Master page
        // For example, check for a specific element on the Parameter Master page
    }

    public void clickCompetencyDropdown() {
        WebElement competencyDropdownElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.competencyDropdown));
        competencyDropdownElement.click();
    }

    public void selectCompetencyOption(String option) {
        WebElement competencyDropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.competencyDropdown));
        Select competencySelect = new Select(competencyDropdownElement);
        competencySelect.selectByVisibleText(option);
    }

    public void enterParameterName(String parameterName) {
        WebElement parameterNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.parameterNameInput));
        parameterNameElement.sendKeys(parameterName);
    }

    public void clickWeightageDropdown() {
        WebElement weightageDropdownElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.weightageDropdown));
        weightageDropdownElement.click();
    }

    public void selectWeightageOption(String option) {
        WebElement weightageDropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.weightageDropdown));
        Select weightageSelect = new Select(weightageDropdownElement);
        weightageSelect.selectByVisibleText(option);
    }

    public void clickAddButton() {
        WebElement addButtonElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.addButton));
        addButtonElement.click();
    }

    public void verifyParameterAdded() {
        // Implement logic to verify that the parameter was added successfully
        // For example, check for a success message or the presence of the new parameter in a list
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}