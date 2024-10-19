package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By usernameInput = By.xpath("//input[@id='username']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By loginButton = By.xpath("//input[@id='btnLogin']");
    public static By quarterlyFeedbackLink = By.xpath("//a[@href='https://mymis.geminisolutions.com/EcDcHierarchy/NineBox']");
    public static By financialYearDropdown = By.xpath("//label[contains(text(), 'Financial Year')]");
    public static By deliveryCouncilDropdown = By.xpath("//label[@id='deliveryCouncilDropdownLable']");
    public static By entriesDropdown = By.xpath("(//a[@href='#'])[1]");
    public static By exportLink = By.xpath("(//a[@href='#'])[1]");
    public static By userManualLink = By.xpath("//a[@id='userManual']");
}