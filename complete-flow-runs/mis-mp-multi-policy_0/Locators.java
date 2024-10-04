// filename: Locators.java

import org.openqa.selenium.By;

public class Locators {
    // Login page locators
    public static final By USERNAME_INPUT = By.xpath("//input[@id='username']");
    public static final By PASSWORD_INPUT = By.xpath("//input[@id='password']");
    public static final By LOGIN_BUTTON = By.xpath("//input[@id='btnLogin']");

    // Navigation locators
    public static final By MANAGE_POLICIES_LINK = By.xpath("//a[@href='https://mymis.geminisolutions.com/Policy/ManagePolicy']");
    public static final By VIEW_POLICY_BUTTON = By.xpath("//a[@href='https://mymis.geminisolutions.com/Policy/ViewPolicy']");

    // Policy action locators
    public static final By DEACTIVATE_POLICY_BUTTON = By.xpath("(//button[@title='DeActivate'])[1]");
    public static final By DELETE_POLICY_BUTTON = By.xpath("(//button[@title='Delete'])[1]");
}