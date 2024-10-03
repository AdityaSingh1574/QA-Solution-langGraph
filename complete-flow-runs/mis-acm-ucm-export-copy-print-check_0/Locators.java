// filename: Locators.java

import org.openqa.selenium.By;

public class Locators {
    // Login Page
    public static final By[] USERNAME_INPUT = {By.xpath("//input[@id='username']")};
    public static final By[] PASSWORD_INPUT = {By.xpath("//input[@id='password']")};
    public static final By[] LOGIN_BUTTON = {By.xpath("//input[@id='btnLogin']")};

    // Navigation
    public static final By[] ACCESS_CARD_MANAGEMENT_SPAN = {By.xpath("//span[contains(text(), 'Access Card Management')]")};
    public static final By[] USER_CARD_MAPPING_LINK = {By.xpath("//a[@href='https://mymis.geminisolutions.com/AccessCard/UserCardMapping']")};

    // User Card Mapping Page
    public static final By[] EXPORT_BUTTON = {By.xpath("(//a[@href='#'])[1]")};

    // The following elements are not available or have NULL XPaths
    // public static final By[] COPY_OPTION = null;
    // public static final By[] EXCEL_OPTION = null;
    // public static final By[] PRINT_BUTTON = null;
}