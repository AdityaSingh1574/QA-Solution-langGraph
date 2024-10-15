package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By usernameInput = By.xpath("//input[@id='username']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By loginButton = By.xpath("//input[@id='btnLogin']");
    public static By applyLnsaLink = By.xpath("//a[@href='https://mymis.geminisolutions.com/Lnsa/Apply']");
    public static By week40Checkbox = By.xpath("//label[contains(text(), 'Week #40')]");
    public static By week41Checkbox = By.xpath("//label[contains(text(), 'Week #41')]");
    public static By submitButton = By.xpath("//button[@id='submitRequest']");
    public static By reasonInput = null;
    public static By finalSubmitButton = null;
}