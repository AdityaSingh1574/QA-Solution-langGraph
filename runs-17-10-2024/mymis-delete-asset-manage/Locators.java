    package locators;

    import org.openqa.selenium.By;

    public class Locators {
        public static By usernameInput = By.xpath("//input[@id='username']");
        public static By passwordInput = By.xpath("//input[@id='password']");
        public static By loginButton = By.xpath("//input[@id='btnLogin']");
        public static By manageAssetLink = By.xpath("//a[@href='https://mymis.geminisolutions.com/Asset/Manage']");
        public static By deleteAssetButton = By.xpath("(//button[@title='Delete'])[1]");
        public static By confirmDeleteButton = null;
    }