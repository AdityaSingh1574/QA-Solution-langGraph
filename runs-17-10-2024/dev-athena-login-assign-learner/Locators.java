package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By emailInput = By.xpath("//input[@class='p-inputtext p-component p-element ng-untouched ng-pristine ng-valid']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By signInButton = By.xpath("//button[contains(text(), 'Sign in')]");
    public static By manageCourseSidebar = By.xpath("//span[contains(text(), 'My Course Library')]");
    public static By batchesSidebar = By.xpath("//span[contains(text(), 'Your Mentees')]");
    public static By assignedLearnersCount = By.xpath("//span[contains(text(), '1121')]");
    public static By assignSelectedButton = By.xpath("//button[contains(text(), 'Assign All')]");

    // For NULL values, we'll define them as String to allow flexibility in usage
    public static String actionsIcon = "NULL";
    public static String assignLearnersOption = "NULL";
    public static String confirmYesButton = "NULL";
}