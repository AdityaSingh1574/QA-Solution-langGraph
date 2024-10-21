package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By usernameInput = By.xpath("//input[@id='username']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By loginButton = By.xpath("//input[@id='btnLogin']");
    public static By userManagementSpan = By.xpath("//span[contains(text(), 'User Management')]");
    public static By manageStaffMembersLink = By.xpath("//a[@href='https://mymis.geminisolutions.com/UserManagement/ManageStaffMember']");
    public static By addNewStaffMemberButton = By.xpath("//button[@id='BtnEditDateforLunch']");
    public static By nameInput = By.xpath("//input[@id='AddStaffMemberName']");
    public static By phoneNumberInput = By.xpath("//input[@id='AddStaffMemberMobile']");
    public static By locationDropdown = null; // As the xpath is "NULL"
    public static By saveButton = By.xpath("//button[@id='btnChangeADPass']");
}