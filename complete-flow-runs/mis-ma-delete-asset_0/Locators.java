// filename: Locators.java

import org.openqa.selenium.By;

public class Locators {
    // Login page locators
    public static final By[] USERNAME_INPUT = {By.xpath("//input[@id='username']")};
    public static final By[] PASSWORD_INPUT = {By.xpath("//input[@id='password']")};
    public static final By[] LOGIN_BUTTON = {By.xpath("//input[@id='btnLogin']")};

    // Asset management locators
    public static final By[] MANAGE_ASSET_LINK = {By.xpath("//a[@href='https://mymis.geminisolutions.com/Asset/Manage']")};
    public static final By[] DELETE_ASSET_BUTTON = {By.xpath("(//button[@title='Delete'])[1]")};

    // Confirmation locator
    public static final By[] CONFIRMATION_YES_BUTTON = null;  // This is set to null as the original JSON had "NULL" for this value
}