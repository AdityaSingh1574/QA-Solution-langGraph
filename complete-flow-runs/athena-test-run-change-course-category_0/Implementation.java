package implementation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.Locators;
import org.junit.Assert;

import java.time.Duration;

public class Implementation {
    private WebDriver driver;
    private WebDriverWait wait;

    public void launchUrl() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dev-athena.geminisolutions.com/login");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.emailInput)).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(Locators.passwordInput).sendKeys(password);
    }

    public void clickSignInButton() {
        driver.findElement(Locators.signInButton).click();
    }

    public void verifyLogin() {
        wait.until(ExpectedConditions.urlContains("dashboard"));
    }

    public void verifyDashboard() {
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    public void selectManageCourses() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.manageCourseSidebar)).click();
    }

    public void selectBatches() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.batchesSidebar)).click();
    }

    public void clickActionsIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.actionsIcon)).click();
    }

    public void selectAssignLearners() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.assignLearnersDropdown)).click();
    }

    public void verifyAssignLearnersPage() {
        wait.until(ExpectedConditions.urlContains("assign-learners"));
    }

    public void expandCategoryDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.categoryDropdown)).click();
    }

    public void selectEC() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.ecOption)).click();
    }

    public void expandSelectedCategoryDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.selectedCategoryDropdown)).click();
    }

    public void selectQA() {
        if (Locators.qaOption != null) {
            wait.until(ExpectedConditions.elementToBeClickable(Locators.qaOption)).click();
        } else {
            System.out.println("QA option locator is not defined.");
        }
    }

    public void verifyFilteredRecords() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.filteredRecords));
        String recordsText = driver.findElement(Locators.filteredRecords).getText();
        Assert.assertTrue(recordsText.contains("EC") && recordsText.contains("QA"));
    }

    public void verifyAssignedLearnersCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.assignedLearnersCount));
        Assert.assertTrue(driver.findElement(Locators.assignedLearnersCount).isDisplayed());
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}