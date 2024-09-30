import org.openqa.selenium.By;

public class AccessCardLocators {
    // Login page locators
    public static final By USERNAME_INPUT = By.xpath("/html/body/div[1]/div[1]/div/form/div[3]/input");
    public static final By PASSWORD_INPUT = By.xpath("/html/body/div[1]/div[1]/div/form/div[4]/input");
    public static final By SIGN_IN_BUTTON = By.xpath("/html/body/div[1]/div[1]/div/form/div[5]/div[2]/input");

    // Navigation locators
    public static final By ACCESS_CARD_MANAGEMENT_DROPDOWN = By.xpath("/html/body/nav/div/div[1]/ul/li[14]/span");
    public static final By MANAGE_CARD_ACCESS = By.xpath("/html/body/nav/div/div[1]/ul/li[14]/ul/li[1]/a");

    // Card management page locators
    public static final By SEARCH_INPUT = By.xpath("/html/body/div[2]/div[1]/section/div/div[2]/section/div/div/div/div[3]/label/input");
    public static final By FIRST_SEARCH_RESULT = By.xpath("/html/body/div[2]/div[1]/section/div/div[2]/section/div/div/div/table/tbody/tr/td[1]");
}