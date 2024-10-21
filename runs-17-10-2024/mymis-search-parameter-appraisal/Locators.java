package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By usernameInput = By.xpath("//input[@id='username']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By loginButton = By.xpath("//input[@id='btnLogin']");
    public static By appraisalManagementSpan = By.xpath("//span[contains(text(), 'Appraisal Management')]");
    public static By parameterMasterLink = By.xpath("//a[@href='https://mymis.geminisolutions.com/AppraisalManagement/ParameterMaster']");
    public static By competencyDropdown = null;
    public static By yearDropdown = null;
    public static By statusDropdown = null;
    public static By searchButton = null;
}