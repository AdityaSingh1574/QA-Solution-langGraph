package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By usernameInput = By.xpath("//input[@id='username']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By loginButton = By.xpath("//input[@id='btnLogin']");
    public static By administrationsSpan = By.xpath("//span[contains(text(), 'Administrations')]");
    public static By userRoleLink = By.xpath("//a[@href='https://mymis.geminisolutions.com/Administrations/UserRole']");
    public static By userRoleDropdown = By.xpath("//a[@href='https://mymis.geminisolutions.com/Administrations/UserRole']");
    public static By editRoleButton = By.xpath("(//button[@title='Edit'])[1]");
    public static By updateButton = By.xpath("//button[@id='btnChangeADPass']");
}