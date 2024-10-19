package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By usernameInput = By.xpath("//input[@id='username']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By loginButton = By.xpath("//input[@id='btnLogin']");
    public static By ecDcManagementLink = By.xpath("//a[contains(text(), 'EC DC Hierarchy')]");
    public static By manageClientLink = By.xpath("//a[@href='https://mymis.geminisolutions.com/EcDcHierarchy/ManageClient']");
    public static By searchInput = By.xpath("//input[@class='form-control input-sm']");
}