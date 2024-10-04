// filename: TaskManagementLocators.java

import org.openqa.selenium.By;

public class TaskManagementLocators {
    public static final By USERNAME_INPUT = By.xpath("//input[@id='username']");
    public static final By PASSWORD_INPUT = By.xpath("//input[@id='password']");
    public static final By LOGIN_BUTTON = By.xpath("//input[@id='btnLogin']");
    public static final By TASK_MANAGEMENT_SPAN = By.xpath("//span[contains(text(), 'Task Management')]");
    public static final By MANAGE_TASK_SUB_DETAILS_1_LINK = By.xpath("//a[@href='https://mymis.geminisolutions.com/TaskManagement/ManageTaskSubDetail1']");
    public static final By ADD_NEW_TASK_SUB_DETAIL_1_BUTTON = By.xpath("//button[contains(text(), 'Add new task sub detail 1')]");
    public static final By ENTER_TASK_SUB_DETAIL1_NAME_INPUT = By.xpath("//input[@id='taskSubDetail1Name']");
    public static final By FINAL_ADD_TASK_SUB_DETAIL1_BUTTON = By.xpath("//button[@id='addTaskSubDetail1Btn']");
}