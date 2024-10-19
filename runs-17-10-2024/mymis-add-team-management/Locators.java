package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By usernameInput = By.xpath("//input[@id='username']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By loginButton = By.xpath("//input[@id='btnLogin']");
    public static By teamManagementSpan = By.xpath("//span[contains(text(), 'Team Management')]");
    public static By teamInformationLink = By.xpath("//a[@href='https://mymis.geminisolutions.com/TeamManagement/TeamInformation']");
    public static By saveButton = By.xpath("//button[@id='btnAddTeamInfo']");

    // For elements with NULL xpath, we'll define them as String to be used later if needed
    public static String teamNameInput = "NULL";
    public static String weekStartDayDropdown = "NULL";
    public static String departmentDropdown = "NULL";
    public static String teamHeadDropdown = "NULL";
}