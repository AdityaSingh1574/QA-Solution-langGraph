// filename: Locators.java

import org.openqa.selenium.By;

public class Locators {
    // Login page elements
    public static final By USERNAME_INPUT = By.xpath("//input[@id='username']");
    public static final By PASSWORD_INPUT = By.xpath("//input[@id='password']");
    public static final By LOGIN_BUTTON = By.xpath("//input[@id='btnLogin']");

    // Export options
    public static final By EXPORT_BUTTON = By.xpath("//button[@id='btnBookOrUpdateForDrop']");
    public static final By COPY_OPTION = By.xpath("//button[@id='btnBookOrUpdateForDrop']");
    public static final By EXCEL_OPTION = By.xpath("//button[@id='btnBookOrUpdateForDrop']");

    // Print button
    public static final By PRINT_BUTTON = By.xpath("//button[@id='btnBookOrUpdateForDrop']");
}