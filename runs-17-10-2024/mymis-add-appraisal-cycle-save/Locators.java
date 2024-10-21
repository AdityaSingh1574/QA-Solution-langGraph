package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By usernameInput = By.xpath("//input[@id='username']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By loginButton = By.xpath("//input[@id='btnLogin']");
    public static By appraisalCycleLink = By.xpath("//a[@href='https://mymis.geminisolutions.com/AppraisalManagement/AppraisalCycle']");
    public static By addNewButton = By.xpath("//button[contains(text(), 'Add Appraisal Cycle')]");
    public static By countryDropdown = null;
    public static By yearDropdown = null;
    public static By monthDropdown = null;
    public static By saveButton = null;
}