package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By emailInput = By.xpath("//input[@class='p-inputtext p-component p-element ng-untouched ng-pristine ng-valid']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By signInButton = By.xpath("//button[contains(text(), 'Sign in')]");
    public static By manageCoursesSidebar = By.xpath("//span[contains(text(), 'My Course Library')]");
    public static By batchesSidebar = By.xpath("//span[contains(text(), 'Your Mentees')]");
    public static By actionsIcon = By.xpath("//div[contains(text(), 'dummy')]");
    public static By assignLearnersOption = By.xpath("//div[contains(text(), 'dummy')]");
    public static By assignedLearnersCount = By.xpath("//span[contains(text(), 'Assigned')]");
    public static By assignSelectedButton = By.xpath("//button[contains(text(), 'Assign All')]");
    public static By confirmYesButton = By.xpath("//button[contains(text(), '1')]");
}