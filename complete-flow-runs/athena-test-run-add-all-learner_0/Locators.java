package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By emailInput = By.xpath("//input[@id='firstname5']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By signInButton = By.xpath("//button[contains(text(), 'Sign in')]");
    public static By manageCourseSidebar = By.xpath("//span[contains(text(), 'My Course Library')]");
    public static By batchesSidebar = By.xpath("//span[contains(text(), 'Your Mentees')]");
    public static By actionsIcon = By.xpath("//div[contains(text(), 'dummy')]");
    public static By assignedLearnersCount = By.xpath("//span[contains(text(), 'TU')]");
    public static By unassignedLearnerCheckbox = By.xpath("//span[contains(text(), 'Unassigned')]");
    public static By nextPageButton = By.xpath("//button[contains(text(), '2')]");
    public static By assignSelectedButton = By.xpath("//button[contains(text(), 'Assign All')]");

    // For NULL values, we'll define them as strings to allow flexibility in usage
    public static String assignLearnersOption = "NULL";
    public static String confirmAssignmentButton = "NULL";
}