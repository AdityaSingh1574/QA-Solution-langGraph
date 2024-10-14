package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By emailInput = By.xpath("//input[@id='firstname5']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By signInButton = By.xpath("//button[contains(text(), 'Sign in')]");
    public static By manageCourseSidebar = By.xpath("//span[contains(text(), 'My Course Library')]");
    public static By batchesSidebar = By.xpath("//span[contains(text(), 'Your Mentees')]");
    public static By actionsIcon = By.xpath("//div[contains(text(), 'dummy')]");
    public static By assignedLearnersCount = By.xpath("//span[contains(text(), '1113')]");
    public static By statusDropdown = By.xpath("//span[contains(text(), 'Status')]");
    public static By assignedOption = By.xpath("//span[contains(text(), 'Assigned')]");
    public static By filteredRecords = By.xpath("//span[contains(text(), '1 - 10 of 1113 records')]");

    // For NULL value, we'll leave it as a comment
    // public static By assignLearnersOption = By.xpath("NULL");
}