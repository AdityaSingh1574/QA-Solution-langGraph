package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By usernameInput = By.xpath("//input[@id='username']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By loginButton = By.xpath("//input[@id='btnLogin']");
    public static By assetAllocationSpan = By.xpath("//span[contains(text(), 'Asset Allocation')]");
    public static By manageAssetLink = By.xpath("//a[@href='https://mymis.geminisolutions.com/Asset/Manage']");
    public static By addNewAssetTypeButton = By.xpath("//button[@id='btnAddNewAssetTypeDetail']");
    public static By addButton = By.xpath("//button[@id='btnAddAssetType']");

    // For NULL values, we'll leave them as comments
    // public static By assetTypeInput = By.xpath("NULL");
    // public static By isTemporaryDropdown = By.xpath("NULL");
}