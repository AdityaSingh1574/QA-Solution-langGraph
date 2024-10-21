package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By usernameInput = By.xpath("//input[@id='username']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By loginButton = By.xpath("//input[@id='btnLogin']");
    public static By mealManagementSpan = By.xpath("//span[contains(text(), 'Meal Management')]");
    public static By mealPackageLink = By.xpath("//a[@href='https://mymis.geminisolutions.com/MealManagement/MealPackage']");
    public static By addMealPackageButton = By.xpath("//button[contains(text(), 'Add Meal Package')]");
    public static By mealPeriodDropdown = By.xpath("//label[contains(text(), 'Meal Period')]");
    public static By mealTypeDropdown = By.xpath("//label[contains(text(), 'Meal Type')]");
    public static By mealCategoryDropdown = By.xpath("//label[contains(text(), 'Meal Category')]");
    public static By saveButton = By.xpath("(//button[@class='btn btn-success'])[1]");
}