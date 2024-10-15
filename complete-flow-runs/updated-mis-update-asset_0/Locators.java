package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By usernameInput = By.xpath("//input[@id='username']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By loginButton = By.xpath("//input[@id='btnLogin']");
    public static By assetAllocationSpan = By.xpath("//span[contains(text(), 'Asset Allocation')]");
    public static By manageAssetLink = By.xpath("//a[@href='https://mymis.geminisolutions.com/Asset/Manage']");
    public static By editAssetButton = By.xpath("(//button[@title='Edit'])[1]");
    public static By assetTypeDropdown = null;
    public static By serialNumberInput = null;
    public static By updateAssetButton = By.xpath("//button[@id='btnAddAssetType']");
}