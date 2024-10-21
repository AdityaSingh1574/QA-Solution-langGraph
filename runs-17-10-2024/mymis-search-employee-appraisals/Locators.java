package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By usernameInput = By.xpath("//input[@id='username']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By loginButton = By.xpath("//input[@id='btnLogin']");
    public static By appraisalManagementSpan = By.xpath("//span[contains(text(), 'Appraisal Management')]");
    public static By employeesAppraisalLink = By.xpath("//a[@href='https://mymis.geminisolutions.com/AppraisalManagement/EmployeesAppraisal']");
    public static By appraisalCycleDropdown = By.xpath("//a[@href='https://mymis.geminisolutions.com/AppraisalManagement/AppraisalCycle']");
    public static By dcChairDropdown = By.xpath("//a[@href='https://mymis.geminisolutions.com/EcDcHierarchy/ManageDC']");
    public static By searchButton = By.xpath("//button[@id='btnChangeADPass']");
}