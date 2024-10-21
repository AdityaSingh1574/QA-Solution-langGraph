package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By usernameInput = By.xpath("//input[@id='username']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By loginButton = By.xpath("//input[@id='btnLogin']");
    public static By manageTeamAppraisalLink = By.xpath("//a[@href='https://mymis.geminisolutions.com/AppraisalManagement/ManageTeamAppraisal']");
    public static By appraisalCycleDropdown = null;
    public static By locationDropdown = null;
    public static By verticalDropdown = null;
    public static By departmentDropdown = null;
    public static By searchButton = null;
}