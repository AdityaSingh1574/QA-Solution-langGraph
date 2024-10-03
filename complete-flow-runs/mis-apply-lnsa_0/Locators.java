// filename: Locators.java

import org.openqa.selenium.By;

public class Locators {
    public static class LoginPageLocators {
        public static final By USERNAME_INPUT = By.xpath("//input[@id='username']");
        public static final By PASSWORD_INPUT = By.xpath("//input[@id='password']");
        public static final By LOGIN_BUTTON = By.xpath("//input[@id='btnLogin']");
    }

    public static class LNSAPageLocators {
        public static final By APPLY_LNSA_LINK = By.xpath("//a[@href='https://mymis.geminisolutions.com/Lnsa/Apply']");
        public static final By WEEK_40_CHECKBOX = By.xpath("//label[contains(text(), 'Week #40')]");
        public static final By WEEK_41_CHECKBOX = By.xpath("//label[contains(text(), 'Week #41')]");
        public static final By SUBMIT_BUTTON = By.xpath("//button[@id='submitRequest']");

        // Note: The following locators are set to null as their XPaths were marked as "NULL" in the input
        public static final By REASON_INPUT = null;
        public static final By FINAL_SUBMIT_BUTTON = null;
    }
}