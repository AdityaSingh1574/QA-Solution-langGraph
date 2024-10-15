import org.openqa.selenium.By;

public class TeamManagementLocators {
    // Login page locators
    public static final By USERNAME_INPUT = By.xpath("//input[@id='username']");
    public static final By PASSWORD_INPUT = By.xpath("//input[@id='password']");
    public static final By LOGIN_BUTTON = By.xpath("//input[@id='btnLogin']");

    // Navigation locators
    public static final By TEAM_MANAGEMENT_SPAN = By.xpath("//span[contains(text(), 'Team Management')]");
    public static final By TEAM_INFORMATION_LINK = By.xpath("//a[@href='https://mymis.geminisolutions.com/TeamManagement/TeamInformation']");

    // Team Information page locators
    public static final By TEAM_NAME_INPUT = null;  // XPATH is NULL
    public static final By WEEK_START_DAY_DROPDOWN = null;  // XPATH is NULL
    public static final By DEPARTMENT_DROPDOWN = null;  // XPATH is NULL
    public static final By TEAM_HEAD_DROPDOWN = null;  // XPATH is NULL
    public static final By SAVE_BUTTON = By.xpath("//button[@id='btnAddTeamInfo']");
}