// filename: Locators.java

import org.openqa.selenium.By;

public class Locators {
    public static class LoginPageLocators {
        public static final By USERNAME_INPUT = By.xpath("//input[@id='username']");
        public static final By PASSWORD_INPUT = By.xpath("//input[@id='password']");
        public static final By LOGIN_BUTTON = By.xpath("//input[@id='btnLogin']");
    }

    public static class NavigationLocators {
        public static final By ACCESS_CARD_MANAGEMENT_SPAN = By.xpath("//span[contains(text(), 'Access Card Management')]");
        public static final By USER_CARD_MAPPING_LINK = By.xpath("//a[@href='https://mymis.geminisolutions.com/AccessCard/UserCardMapping']");
    }

    public static class UserCardMappingLocators {
        public static final By SEARCH_INPUT = By.xpath("//input[@class='form-control input-sm']");
    }
}