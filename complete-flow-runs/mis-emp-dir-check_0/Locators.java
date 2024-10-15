// filename: Locators.java

import org.openqa.selenium.By;

public class Locators {
    public static class LoginPageLocators {
        public static final By USERNAME_INPUT = By.xpath("//input[@id='username']");
        public static final By PASSWORD_INPUT = By.xpath("//input[@id='password']");
        public static final By LOGIN_BUTTON = By.xpath("//input[@id='btnLogin']");
    }

    public static class MainPageLocators {
        public static final By EC_DC_HIERARCHY_LINK = By.xpath("//a[contains(text(), 'EC DC Hierarchy')]");
        public static final By SEARCH_INPUT = By.xpath("//input[@class='form-control input-sm']");

        // Note: ENTRIES_DROPDOWN is set to null as its value was "NULL" in the JSON
        public static final By ENTRIES_DROPDOWN = null;
    }
}