package implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import TaskManagementLocators;

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(TaskManagementLocators.USERNAME_INPUT)).sendKeys(userId);
    }

    public void enterPassword(String password) {
        driver.findElement(TaskManagementLocators.PASSWORD_INPUT).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(TaskManagementLocators.LOGIN_BUTTON).click();
    }

    public void navigateToManageTaskSubDetails() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TaskManagementLocators.TASK_MANAGEMENT_SPAN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(TaskManagementLocators.MANAGE_TASK_SUB_DETAILS_1_LINK)).click();
    }

    public void verifyMISHomepage() {
        wait.until(ExpectedConditions.urlContains("mymis.geminisolutions.com"));
    }

    public void clickAddNewTaskDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(TaskManagementLocators.ADD_NEW_TASK_SUB_DETAIL_1_BUTTON)).click();
    }

    public void enterTaskName(String taskName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TaskManagementLocators.ENTER_TASK_SUB_DETAIL1_NAME_INPUT)).sendKeys(taskName);
    }

    public void clickAddButton() {
        driver.findElement(TaskManagementLocators.FINAL_ADD_TASK_SUB_DETAIL1_BUTTON).click();
    }

    public void verifyTaskSubDetailPage() {
        wait.until(ExpectedConditions.urlContains("TaskManagement/ManageTaskSubDetail1"));
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}