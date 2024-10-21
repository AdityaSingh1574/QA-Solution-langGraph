package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By usernameInput = By.xpath("//input[@id='username']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By loginButton = By.xpath("//input[@id='btnLogin']");
    public static By manageSchedulerLink = By.xpath("//a[@href='https://mymis.geminisolutions.com/Administrations/ManageScheduler']");
    public static By addSchedulerActionButton = By.xpath("//button[contains(text(), 'Add Scheduler Action')]");
    public static By schedulerNameInput = By.xpath("NULL");
    public static By descriptionInput = By.xpath("NULL");
    public static By functionNameInput = By.xpath("NULL");
    public static By addButton = By.xpath("NULL");
}