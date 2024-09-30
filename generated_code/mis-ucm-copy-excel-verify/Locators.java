// filename: Locators.java

import org.openqa.selenium.By;

public class Locators {
    // Login page locators
    public static final By[] USERNAME_INPUT = {By.xpath("/html/body/div[1]/div[1]/div/form/div[3]/input")};
    public static final By[] PASSWORD_INPUT = {By.xpath("/html/body/div[1]/div[1]/div/form/div[4]/input")};
    public static final By[] SIGN_IN_BUTTON = {By.xpath("/html/body/div[1]/div[1]/div/form/div[5]/div[2]/input")};

    // Navigation locators
    public static final By[] ACCESS_CARD_MANAGEMENT_DROPDOWN = {By.xpath("/html/body/nav/div/div[1]/ul/li[14]/span")};
    public static final By[] USER_CARD_MANAGEMENT = {By.xpath("/html/body/nav/div/div[1]/ul/li[14]/ul/li[2]/a")};

    // User card management page locators
    public static final By[] EXPORT_BUTTON = {By.xpath("/html/body/div[2]/div[1]/section/div/div/div/section/div[2]/div[1]/section/div/div/div[2]/section/div/div/div/div[2]/a")};
    public static final By[] COPY_BUTTON = {By.xpath("/html/body/div[16]/a[1]")};
    public static final By[] EXCEL_BUTTON = {By.xpath("/html/body/div[16]/a[2]")};
}