package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By usernameInput = By.xpath("//input[@id='username']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By loginButton = By.xpath("//input[@id='btnLogin']");
    public static By ecDcManagementLink = By.xpath("//a[contains(text(), 'EC DC Hierarchy')]");
    public static By manageClientLink = By.xpath("//a[@href='https://mymis.geminisolutions.com/EcDcHierarchy/ManageClient']");
    public static By addClientButton = By.xpath("//button[contains(text(), 'Add Client')]");
    public static By clientNameInput = By.xpath("NULL");
    public static By addressInput = By.xpath("NULL");
    public static By cityInput = By.xpath("NULL");
    public static By countryInput = By.xpath("NULL");
    public static By addButton = By.xpath("//button[@id='btnAddDCs']");
}