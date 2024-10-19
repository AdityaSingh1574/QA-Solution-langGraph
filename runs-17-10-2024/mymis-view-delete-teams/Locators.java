package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By usernameInput = By.xpath("//input[@id='username']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By loginButton = By.xpath("//input[@id='btnLogin']");
    public static By teamInformationLink = By.xpath("//a[@href='https://mymis.geminisolutions.com/TeamManagement/TeamInformation']");
    public static By viewTeamButton = By.xpath("//a[@href='https://mymis.geminisolutions.com/TeamManagement/TeamInformation']");
    public static By deleteButton = By.xpath("//button[@id='btnCloseTeamInfo']");
    public static By confirmDeleteButton = By.xpath("//button[@id='btnAddTeamInfo']");
}