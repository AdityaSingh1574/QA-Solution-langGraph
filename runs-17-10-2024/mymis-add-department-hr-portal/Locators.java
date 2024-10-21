package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By usernameInput = By.xpath("//input[@id='username']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By loginButton = By.xpath("//input[@id='btnLogin']");
    public static By manageDepartmentTeamsLink = By.xpath("//a[@href='https://mymis.geminisolutions.com/HRPortal/ManageDepartment']");
    public static By addNewDepartmentButton = By.xpath("//button[contains(text(), 'Add New Department')]");
    public static By enterDepartmentNameTextarea = By.xpath("//textarea[@id='AddDepartmentName']");
    public static By enterDepartmentDescriptionTextarea = By.xpath("//textarea[@id='AddDepartmentDescription']");
    public static By departmentHeadDropdown = By.xpath("NULL");
    public static By divisionNameDropdown = By.xpath("NULL");
    public static By addButton = By.xpath("NULL");
}