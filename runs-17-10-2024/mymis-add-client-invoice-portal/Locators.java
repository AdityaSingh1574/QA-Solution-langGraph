package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By usernameInput = By.xpath("//input[@id='username']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By loginButton = By.xpath("//input[@id='btnLogin']");
    public static By invoicePortalLink = By.xpath("//a[@href='https://mymis.geminisolutions.com/AccountsPortal/GenerateInvoice']");
    public static By addNewClientButton = By.xpath("//button[@class='btn btn-success']");
    public static By clientNameInput = null;
    public static By saveButton = null;
}