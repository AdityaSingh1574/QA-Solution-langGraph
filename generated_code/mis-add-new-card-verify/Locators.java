// filename: Locators.java

import org.openqa.selenium.By;

public class Locators {
    // Login page
    public static final By[] USERNAME_INPUT = {By.xpath("/html/body/div[1]/div[1]/div/form/div[3]/input")};
    public static final By[] PASSWORD_INPUT = {By.xpath("/html/body/div[1]/div[1]/div/form/div[4]/input")};
    public static final By[] SIGN_IN_BUTTON = {By.xpath("/html/body/div[1]/div[1]/div/form/div[5]/div[2]/input")};

    // Navigation
    public static final By[] ACCESS_CARD_MANAGEMENT_DROPDOWN = {By.xpath("/html/body/nav/div/div[1]/ul/li[14]/span")};

    // Card management page
    public static final By[] ADD_NEW_CARD_BUTTON = {By.xpath("/html/body/div[2]/div[1]/section/div/div[1]/button")};
    public static final By[] NEW_CARD_NUMBER_INPUT = {By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div[1]/div/div[2]/input")};
    public static final By[] TEMP_CARD_CHECKBOX = {By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div[2]/div/div[2]/input")};
    public static final By[] FINAL_ADD_BUTTON = {By.xpath("/html/body/div[2]/div[2]/div/div/div[3]/button[1]")};
}