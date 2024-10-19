package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By usernameInput = By.xpath("//input[@id='username']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By loginButton = By.xpath("//input[@id='btnLogin']");
    public static By manageTaskTeamLink = By.xpath("//a[@href='https://mymis.geminisolutions.com/TaskManagement/ManageTaskTeam']");
    public static By searchInput = By.xpath("//input[@class='form-control input-sm']");

    // For the NULL value, we'll leave it as a comment
    // public static By entriesDropdown = By.xpath("NULL");
}