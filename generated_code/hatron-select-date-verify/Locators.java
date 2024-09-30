// filename: Locators.java

import org.openqa.selenium.By;

public class Locators {
    // Login
    public static final By[] LOGIN_OPTION_DROPDOWN = {By.xpath("/html/body/athena-root/div/athena-auth/athena-login/form/div/div[1]/div[2]/div[1]/div/div/p-dropdown")};
    public static final By[] LOGIN_OPTION_EMAIL = {By.xpath("/html/body/athena-root/div/athena-auth/athena-login/form/div/div[1]/div[2]/div[1]/div/div/p-dropdown/div/div[3]/div/ul/p-dropdownitem[1]")};
    public static final By[] EMAIL_INPUT = {By.xpath("/html/body/athena-root/div/athena-auth/athena-login/form/div/div[1]/div[2]/div[2]/div/div/input")};
    public static final By[] PASSWORD_INPUT = {By.xpath("/html/body/athena-root/div/athena-auth/athena-login/form/div/div[1]/div[2]/div[2]/div/div/input")};
    public static final By[] LOGIN_BUTTON = {By.xpath("/html/body/athena-root/div/athena-auth/athena-login/form/div/div[1]/div[2]/div[4]/button")};

    // Navigation
    public static final By[] HAMBURGER_BUTTON = {By.xpath("/html/body/athena-root/div/athena-layout/div/div[1]/athena-header/p-toolbar/div/div[1]/em")};
    public static final By[] TESTS_DROPDOWN = {By.xpath("/html/body/athena-root/div/athena-layout/div/div[2]/div[1]/athena-sidemenu/p-sidebar/div/div[2]/p-panelmenu/div/div[2]/div[1]/a")};
    public static final By[] TEST_CONTROLS_OPTIONS = {By.xpath("/html/body/athena-root/div/athena-layout/div/div[2]/div[1]/athena-sidemenu/p-sidebar/div/div[2]/p-panelmenu/div/div[2]/div[2]/div/p-panelmenusub/ul/li[1]/a")};

    // Date Selection
    public static final By[] START_DATE_SELECTION_BUTTON = {By.xpath("//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/div/div/div/p-table/div/div[1]/div/div[2]/span/p-calendar/span/button")};
    public static final By[] END_DATE_SELECTION_BUTTON = {By.xpath("//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/div/div/div/p-table/div/div[1]/div/div[3]/span/p-calendar/span/button")};
    public static final By[] START_DATE_TARGET = {By.xpath("/html/body/div/div[1]/div/div[2]/table/tbody/tr[1]/td[1]")};
    public static final By[] END_DATE_TARGET = {By.xpath("/html/body/div/div[1]/div/div[2]/table/tbody/tr[5]/td[2]")};

    // Course Counter
    public static final By[] COURSE_COUNTER = {By.xpath("//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/div/div/div/div[2]/div[1]/span")};
}