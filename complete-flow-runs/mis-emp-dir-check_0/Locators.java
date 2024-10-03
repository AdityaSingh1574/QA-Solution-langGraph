// filename: Locators.java

import org.openqa.selenium.By;

public class Locators {
    // Login page
    public static final By[] USERNAME_INPUT = {By.xpath("//input[@id='username']")};
    public static final By[] PASSWORD_INPUT = {By.xpath("//input[@id='password']")};
    public static final By[] LOGIN_BUTTON = {By.xpath("//input[@id='btnLogin']")};

    // Navigation
    public static final By[] EMPLOYEE_DIRECTORY_LINK = {By.xpath("//a[contains(text(), 'EC DC Hierarchy')]")};

    // Search functionality
    public static final By[] SEARCH_INPUT = {By.xpath("//input[@class='form-control input-sm']")};

    // Note: ENTRIES_DROPDOWN is not included as its value is "NULL" in the provided JSON
}