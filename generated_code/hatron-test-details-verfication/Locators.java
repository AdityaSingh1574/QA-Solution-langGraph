// filename: LoginPageLocators.java

import org.openqa.selenium.By;

public class LoginPageLocators {
    public static final By LOGIN_OPTION_DROPDOWN = By.xpath("/html/body/athena-root/div/athena-auth/athena-login/form/div/div[1]/div[2]/div[1]/div/div/p-dropdown");
    public static final By LOGIN_OPTION_EMAIL = By.xpath("/html/body/athena-root/div/athena-auth/athena-login/form/div/div[1]/div[2]/div[1]/div/div/p-dropdown/div/div[3]/div/ul/p-dropdownitem[1]");
    public static final By EMAIL_INPUT = By.xpath("/html/body/athena-root/div/athena-auth/athena-login/form/div/div[1]/div[2]/div[2]/div/div/input");
    public static final By PASSWORD_INPUT = By.xpath("/html/body/athena-root/div/athena-auth/athena-login/form/div/div[1]/div[2]/div[2]/div/div/input");
    public static final By LOGIN_BUTTON = By.xpath("/html/body/athena-root/div/athena-auth/athena-login/form/div/div[1]/div[2]/div[4]/button");
}

// filename: MainPageLocators.java

import org.openqa.selenium.By;

public class MainPageLocators {
    public static final By HAMBURGER_BUTTON = By.xpath("/html/body/athena-root/div/athena-layout/div/div[1]/athena-header/p-toolbar/div/div[1]/em");
    public static final By TESTS_DROPDOWN = By.xpath("/html/body/athena-root/div/athena-layout/div/div[2]/div[1]/athena-sidemenu/p-sidebar/div/div[2]/p-panelmenu/div/div[2]/div[1]/a");
    public static final By TEST_CONTROLS_OPTIONS = By.xpath("/html/body/athena-root/div/athena-layout/div/div[2]/div[1]/athena-sidemenu/p-sidebar/div/div[2]/p-panelmenu/div/div[2]/div[2]/div/p-panelmenusub/ul/li[1]/a");
    public static final By FIRST_TEST = By.xpath("//*[@id=\"font-size\"]");
    public static final By TEST_URL_SPAN = By.xpath("//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/p-sidebar/div/div[2]/div[5]/span");
}