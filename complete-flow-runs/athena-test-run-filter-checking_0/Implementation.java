package implementations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
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

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.emailInput)).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(Locators.passwordInput).sendKeys(password);
    }

    public void clickSignInButton() {
        driver.findElement(Locators.signInButton).click();
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
        // Since the locator for this action is NULL, we'll skip this step
        // Normally, you would implement the action here
    }

    public int getAssignedLearnersCount() {
        String countText = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.assignedLearnersCount)).getText();
        return Integer.parseInt(countText);
    }

    public void expandStatusDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.statusDropdown)).click();
    }

    public void selectAssignedStatus() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.assignedOption)).click();
    }

    public boolean verifyFilteredRecords() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.filteredRecords)).isDisplayed();
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}