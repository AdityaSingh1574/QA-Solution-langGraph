// filename: Locators.java

import org.openqa.selenium.By;

public class Locators {
    // Login Page
    public static final By[] USERNAME_INPUT = {By.xpath("//input[@id='username']")};
    public static final By[] PASSWORD_INPUT = {By.xpath("//input[@id='password']")};
    public static final By[] LOGIN_BUTTON = {By.xpath("//input[@id='btnLogin']")};

    // Asset Management Page
    public static final By[] ASSET_ALLOCATION_SPAN = {By.xpath("//span[contains(text(), 'Asset Allocation')]")};
    public static final By[] MANAGE_ASSET_LINK = {By.xpath("//a[@href='https://mymis.geminisolutions.com/Asset/Manage']")};
    public static final By[] EDIT_ASSET_BUTTON = {By.xpath("(//button[@title='Edit'])[1]")};

    // Asset Edit Page
    public static final By[] ASSET_TYPE_DROPDOWN = null;  // XPATH not provided
    public static final By[] SERIAL_NUMBER_INPUT = null;  // XPATH not provided
    public static final By[] UPDATE_BUTTON = null;  // XPATH not provided
}