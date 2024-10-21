package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By usernameInput = By.xpath("//input[@id='username']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By loginButton = By.xpath("//input[@id='btnLogin']");
    public static By manageDesignationLink = By.xpath("//a[@href='https://mymis.geminisolutions.com/HRPortal/ManageDesignation']");
    public static By addButton = By.xpath("//button[contains(text(), 'New Designation Group')]");
    public static By designationGroupTitleInput = By.xpath("//textarea[@id='DesignationGroupTitleAdd']");
    public static By saveButton = By.xpath("//button[contains(text(), 'New Designation Group')]");
}