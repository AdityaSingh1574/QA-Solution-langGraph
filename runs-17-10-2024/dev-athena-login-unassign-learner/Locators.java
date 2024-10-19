package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By emailInput = By.xpath("//input[@id='firstname5']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By signInButton = By.xpath("//button[contains(text(), 'Sign in')]");
    public static By manageCourses = By.xpath("//span[contains(text(), 'My Course Library')]");
    public static By batches = By.xpath("//span[contains(text(), 'Your Mentees')]");
    public static By dummyRecord = By.xpath("//div[contains(text(), 'dummy')]");
    public static By assignedLearnersCount = By.xpath("//span[contains(text(), '1121')]");
    public static By learnerEmailInput = By.xpath("//input[@class='p-inputtext p-component p-element ng-untouched ng-pristine ng-valid']");
    public static By unassignSelectedButton = By.xpath("//button[contains(text(), 'Unassign All')]");
    public static By updatedLearnersCount = By.xpath("//span[contains(text(), '1121')]");

    // For NULL values, we'll define them as null
    public static By actionsIcon = null;
    public static By assignLearnersOption = null;
    public static By confirmUnassignButton = null;
}