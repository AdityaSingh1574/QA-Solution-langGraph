package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By emailInput = By.xpath("//input[@id='firstname5']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By signInButton = By.xpath("//button[contains(text(), 'Sign in')]");
    public static By manageCoursesSidebar = By.xpath("//span[contains(text(), 'My Course Library')]");
    public static By batchesSidebar = By.xpath("//span[contains(text(), 'Your Mentees')]");
    public static By dummyRecord = By.xpath("//div[contains(text(), 'dummy')]");
    public static By categoryDropdown = By.xpath("(//input[@class='p-element'])[1]");
    public static By ecOption = By.xpath("//span[contains(text(), 'EC')]");
    public static By selectedCategoryDropdown = By.xpath("(//input[@class='p-element'])[2]");
    public static By assignedLearnersCount = By.xpath("//span[contains(text(), '1121')]");
    public static By unassignButton = By.xpath("//button[contains(text(), 'Unassign All')]");

    // Elements with NULL xpaths are commented out
    // public static By actionsIcon;
    // public static By assignLearnersOption;
    // public static By qaOption;
    // public static By filteredLearnersList;
}