package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By usernameInput = By.xpath("//input[@id='username']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By loginButton = By.xpath("//input[@id='btnLogin']");
    public static By manageMenuLink = By.xpath("//a[@href='https://mymis.geminisolutions.com/Administrations/ManageMenu']");
    public static By addNavigationMenuButton = By.xpath("//button[contains(text(), 'Add Navigation Menu')]");
    public static By addNavigationMenuSubmitButton = By.xpath("//button[contains(text(), 'Add Navigation Menu')]");

    // The following elements have "NULL" xpaths, so they are commented out
    // public static By menuNameInput = By.xpath("NULL");
    // public static By actionNameInput = By.xpath("NULL");
    // public static By controllerNameInput = By.xpath("NULL");
    // public static By cssClassInput = By.xpath("NULL");
    // public static By menuSequenceInput = By.xpath("NULL");
    // public static By selectMenuToggle = By.xpath("NULL");
    // public static By isLinkEnabledCheckbox = By.xpath("NULL");
    // public static By isDelegatableCheckbox = By.xpath("NULL");
}