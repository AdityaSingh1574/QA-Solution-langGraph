package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By usernameInput = By.xpath("//input[@id='username']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By loginButton = By.xpath("//input[@id='btnLogin']");
    public static By managePoliciesLink = By.xpath("//a[@href='https://mymis.geminisolutions.com/Policy/ManagePolicy']");
    public static By viewPolicyButton = By.xpath("//a[@href='https://mymis.geminisolutions.com/Policy/ViewPolicy']");
    public static By deactivatePolicyButton = By.xpath("(//button[@title='DeActivate'])[1]");
    public static By deletePolicyButton = By.xpath("(//button[@title='Delete'])[1]");
    public static By confirmYesButton = By.xpath("//button[@id='btnChangeADPass']");
}