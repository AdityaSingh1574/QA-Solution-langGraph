package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By usernameInput = By.xpath("//input[@id='username']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By loginButton = By.xpath("//input[@id='btnLogin']");
    public static By appraisalCycleDropdown = By.xpath("//a[@href='https://mymis.geminisolutions.com/AppraisalManagement/AppraisalCycle']");
    public static By locationDropdown = By.xpath("//a[@href='https://mymis.geminisolutions.com/AppraisalManagement/ParameterMaster']");
    public static By verticalDropdown = By.xpath("//a[@href='https://mymis.geminisolutions.com/AppraisalManagement/ParameterMaster']");
    public static By designationDropdown = By.xpath("//a[@href='https://mymis.geminisolutions.com/AppraisalManagement/ParameterMaster']");
    public static By searchButton = By.xpath("//button[@id='btnAddParameter']");
}