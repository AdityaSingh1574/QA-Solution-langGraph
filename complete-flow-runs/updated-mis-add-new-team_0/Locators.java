package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By usernameInput = By.xpath("//input[@id='username']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By loginButton = By.xpath("//input[@id='btnLogin']");
    public static By teamManagementSpan = By.xpath("//span[contains(text(), 'Team Management')]");
    public static By teamInformationLink = By.xpath("//a[@href='https://mymis.geminisolutions.com/TeamManagement/TeamInformation']");
    public static By saveButton = By.xpath("//button[@id='btnAddTeamInfo']");

    // For elements with NULL xpath, we'll leave them as comments
    // public static By teamNameInput = By.xpath("");
    // public static By weekStartDaySelect = By.xpath("");
    // public static By departmentSelect = By.xpath("");
    // public static By teamHeadSelect = By.xpath("");
}