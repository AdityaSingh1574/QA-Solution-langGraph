import org.openqa.selenium.By;

public class LoginPageLocators {
    public static final By USERNAME_INPUT = By.xpath("//input[@id='username']");
    public static final By PASSWORD_INPUT = By.xpath("//input[@id='password']");
    public static final By LOGIN_BUTTON = By.xpath("//input[@id='btnLogin']");
}

public class LeaveManagementPageLocators {
    public static final By UPDATE_LINK = By.xpath("//a[@href='https://mymis.geminisolutions.com/LeaveManagement/Update']");
    public static final By FINANCIAL_YEAR_DROPDOWN = By.xpath("//span[@id='select2-year-container']");
    public static final By EMPLOYEE_STATUS_DROPDOWN = By.xpath("//span[@id='select2-ddlUserStatus-container']");
    public static final By EMPLOYEE_SEARCH_INPUT = By.xpath("//span[@id='select2-leaveEmployeeName-container']");
    public static final By APPLY_LEAVE_BUTTON = By.xpath("//input[@id='btnApplyLeaveOnUserBehalf']");
}