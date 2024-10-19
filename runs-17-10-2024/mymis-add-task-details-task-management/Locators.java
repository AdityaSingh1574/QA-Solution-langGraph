package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By usernameInput = By.xpath("//input[@id='username']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By loginButton = By.xpath("//input[@id='btnLogin']");
    public static By manageTaskSubDetails1Link = By.xpath("//a[@href='https://mymis.geminisolutions.com/TaskManagement/ManageTaskSubDetail1']");
    public static By addNewTaskSubDetail1Button = By.xpath("//button[contains(text(), 'Add new task sub detail 1')]");
    public static By enterTaskSubDetail1NameInput = By.xpath("//input[@id='taskSubDetail1Name']");
    public static By finalAddTaskSubDetail1Button = By.xpath("//button[@id='addTaskSubDetail1Btn']");
}