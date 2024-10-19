package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By emailInput = By.xpath("//input[@id='firstname5']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By signInButton = By.xpath("//button[contains(text(), 'Sign in')]");
    public static By manageCourses = By.xpath("//span[contains(text(), 'My Course Library')]");
    public static By batches = By.xpath("//span[contains(text(), 'Your Mentees')]");
    public static By assignedLearnersCount = By.xpath("//span[contains(text(), '1121')]");
    public static By categoryDropdown = By.xpath("//span[contains(text(), 'Category')]");
    public static By ecOption = By.xpath("//span[contains(text(), 'EC')]");
    public static By selectedCategoryDropdown = By.xpath("//span[contains(text(), 'Selected Category')]");
    public static By filteredRecords = By.xpath("//span[contains(text(), '1 - 10 of 1121 records')]");

    // Elements with NULL xpaths are commented out
    // public static By actionsIcon;
    // public static By assignLearnersOption;
    // public static By qaOption;
}