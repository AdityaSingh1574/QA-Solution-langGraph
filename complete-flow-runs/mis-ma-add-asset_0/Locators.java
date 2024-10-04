import org.openqa.selenium.By;

public class Locators {
    public static class LoginPageLocators {
        public static final By USERNAME_INPUT = By.xpath("//input[@id='username']");
        public static final By PASSWORD_INPUT = By.xpath("//input[@id='password']");
        public static final By LOGIN_BUTTON = By.xpath("//input[@id='btnLogin']");
    }

    public static class AssetManagementLocators {
        public static final By ASSET_ALLOCATION_SPAN = By.xpath("//span[contains(text(), 'Asset Allocation')]");
        public static final By MANAGE_ASSET_LINK = By.xpath("//a[@href='https://mymis.geminisolutions.com/Asset/Manage']");
        public static final By ADD_NEW_ASSET_TYPE_BUTTON = By.xpath("//button[@id='btnAddNewAssetTypeDetail']");
        public static final By ADD_BUTTON = By.xpath("//button[@id='btnAddAssetType']");

        // For the NULL values, we'll use placeholder comments
        // public static final By ASSET_TYPE_INPUT = null;  // XPath was NULL in the provided JSON
        // public static final By IS_TEMPORARY_DROPDOWN = null;  // XPath was NULL in the provided JSON
    }
}