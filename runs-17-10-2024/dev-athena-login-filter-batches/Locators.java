package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By emailInput = By.xpath("//input[@id='firstname5']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By signInButton = By.xpath("//button[contains(text(), 'Sign in')]");
    public static By manageCourseSidebar = By.xpath("//span[contains(text(), 'My Course Library')]");
    public static By batchesSidebar = By.xpath("//span[contains(text(), 'Total Courses')]");
    public static By assignLearnersDropdown = By.xpath("//span[contains(text(), 'Action Performed On Learners')]");
    public static By assignedLearnersCount = By.xpath("//span[contains(text(), '1121')]");
    public static By statusDropdown = By.xpath("//span[contains(text(), 'Status')]");
    public static By filteredRecords = By.xpath("//span[contains(text(), '1 - 10 of 1121 records')]");

    // For NULL or unavailable xpaths, we'll define them as strings
    public static String actionsIcon = "NULL";
    public static String assignedStatusOption = "NULL";
}