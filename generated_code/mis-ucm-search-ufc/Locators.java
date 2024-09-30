// filename: Locators.java

import org.openqa.selenium.By;

public class Locators {
    // Login Page
    public static final By[] USERNAME_INPUT = {By.xpath("/html/body/div[1]/div[1]/div/form/div[3]/input")};
    public static final By[] PASSWORD_INPUT = {By.xpath("/html/body/div[1]/div[1]/div/form/div[4]/input")};
    public static final By[] SIGN_IN_BUTTON = {By.xpath("/html/body/div[1]/div[1]/div/form/div[5]/div[2]/input")};

    // Navigation
    public static final By[] ACCESS_CARD_MANAGEMENT_DROPDOWN = {By.xpath("/html/body/nav/div/div[1]/ul/li[14]/span")};
    public static final By[] USER_CARD_MANAGEMENT = {By.xpath("/html/body/nav/div/div[1]/ul/li[14]/ul/li[2]/a")};

    // User Card Management Page
    public static final By[] ENTRY_SELECTION_DROPDOWN = {By.xpath("/html/body/div[2]/div[1]/section/div/div/div/section/div[2]/div[1]/section/div/div/div[2]/section/div/div/div/div[1]/label/select")};
    public static final By[] SEARCH_INPUT = {By.xpath("/html/body/div[2]/div[1]/section/div/div/div/section/div[2]/div[1]/section/div/div/div[2]/section/div/div/div/div[3]/label/input")};
    public static final By[] UNFINALIZE_BUTTON = {By.xpath("/html/body/div[2]/div[1]/section/div/div/div/section/div[2]/div[1]/section/div/div/div[2]/section/div/div/div/table/tbody/tr[2]/td/ul/li/span[2]/div/button")};
    public static final By[] ADDITIONAL_OPTION = {By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/div[3]/div/div/button[1]")};
}