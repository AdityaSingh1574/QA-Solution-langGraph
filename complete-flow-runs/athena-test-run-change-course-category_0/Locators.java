package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By emailInput = By.xpath("//input[@id='firstname5']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By signInButton = By.xpath("//button[contains(text(), 'Sign in')]");
    public static By manageCourseSidebar = By.xpath("//span[contains(text(), 'My Course Library')]");
    public static By batchesSidebar = By.xpath("//span[contains(text(), 'Total Courses')]");
    public static By actionsIcon = By.xpath("//button[contains(text(), '3')]");
    public static By assignLearnersDropdown = By.xpath("//span[contains(text(), 'Action Performed On Learners')]");
    public static By assignedLearnersCount = By.xpath("//span[contains(text(), '1113')]");
    public static By categoryDropdown = By.xpath("//span[contains(text(), 'Category')]");
    public static By ecOption = By.xpath("//span[contains(text(), 'EC')]");
    public static By selectedCategoryDropdown = By.xpath("//span[contains(text(), 'Selected Category')]");
    public static By qaOption = null;
    public static By filteredRecords = By.xpath("//span[contains(text(), '1 - 10 of 1113 records')]");
}