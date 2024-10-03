Here's the translated Java code:

---JAVA-CODE---
// filename: Locators.java

import org.openqa.selenium.By;

public class Locators {
    public static class LoginPageLocators {
        public static final By USERNAME_INPUT = By.xpath("//input[@id='username']");
        public static final By PASSWORD_INPUT = By.xpath("//input[@id='password']");
        public static final By LOGIN_BUTTON = By.xpath("//input[@id='btnLogin']");
    }

    public static class AccessCardManagementLocators {
        public static final By ACCESS_CARD_MANAGEMENT_SPAN = By.xpath("//span[contains(text(), 'Access Card Management')]");
        public static final By MANAGE_ACCESS_CARD_LINK = By.xpath("//a[@href='https://mymis.geminisolutions.com/AccessCard/Manage']");
    }

    public static class PaginationLocators {
        public static final By RECORD_SELECTION_DROPDOWN = By.xpath("(//a[@href='#'])[8]");
        public static final By NEXT_BUTTON = By.xpath("(//a[@href='#'])[9]");
        public static final By PREVIOUS_BUTTON = By.xpath("(//a[@href='#'])[2]");
    }
}
---JAVA-CODE---