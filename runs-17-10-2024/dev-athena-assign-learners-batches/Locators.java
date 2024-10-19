package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By emailInput = By.xpath("//input[@id='firstname5']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By signInButton = By.xpath("//button[contains(text(), 'Sign in')]");
    public static By manageCoursesSidebar = By.xpath("//span[contains(text(), 'My Course Library')]");
    public static By batchesSidebar = By.xpath("//span[contains(text(), 'Your Mentees')]");
    public static By dummyRecord = By.xpath("//div[contains(text(), 'dummy')]");
    public static By assignedLearnersCount = By.xpath("//span[contains(text(), '1121')]");
    public static By unassignedLearnerCheckbox = By.xpath("//span[contains(text(), 'Unassigned')]");
    public static By nextPageButton = By.xpath("//button[contains(text(), '2')]");
    public static By assignSelectedButton = By.xpath("//button[contains(text(), 'Assign All')]");

    // For elements with NULL xpath, we'll define them as null
    public static By actionsIcon = null;
    public static By assignLearnersOption = null;
    public static By confirmAssignmentButton = null;
}