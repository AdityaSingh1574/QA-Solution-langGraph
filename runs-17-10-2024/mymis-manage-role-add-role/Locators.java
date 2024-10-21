package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By usernameInput = By.xpath("//input[@id='username']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By loginButton = By.xpath("//input[@id='btnLogin']");
    public static By administrationsSpan = By.xpath("//span[contains(text(), 'Administrations')]");
    public static By manageRoleLink = By.xpath("//a[@href='https://mymis.geminisolutions.com/Administrations/ManageRole']");
    public static By roleNameInput = null;
    public static By addRoleButton = By.xpath("//button[contains(text(), 'Add Role')]");
}