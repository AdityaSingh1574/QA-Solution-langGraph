package locators;

import org.openqa.selenium.By;

public class Locators {
    public static By usernameInput = By.xpath("//input[@id='username']");
    public static By passwordInput = By.xpath("//input[@id='password']");
    public static By loginButton = By.xpath("//input[@id='btnLogin']");
    public static By manageLink = By.xpath("//a[@href='https://mymis.geminisolutions.com/MealManagement/MealManage']");
    public static By addMealPeriodButton = By.xpath("//button[contains(text(), 'Add Meal Period')]");
    public static By saveMealPeriodButton = By.xpath("//button[@id='btnAddMealPeriod']");
    public static By mealTypeTab = By.xpath("//a[@href='#tabs-2-tab-2']");
    public static By addMealTypeButton = By.xpath("//button[contains(text(), 'Add Meal Type')]");
    public static By saveMealTypeButton = By.xpath("//button[@id='btnAddMealType']");
    public static By mealCategoryTab = By.xpath("//a[@href='#tabs-2-tab-3']");
    public static By addMealCategoryButton = By.xpath("//button[contains(text(), 'Add Meal Category')]");
    public static By saveMealCategoryButton = By.xpath("//button[@id='btnAddMealCategory']");
    public static By mealDishesTab = By.xpath("//a[@href='#tabs-2-tab-4']");
    public static By addMealDishesButton = By.xpath("//button[contains(text(), 'Add Meal Dishes')]");
    public static By saveMealDishesButton = By.xpath("//button[@id='btnAddMealDish']");

    // For elements with NULL xpath, we'll define them as String to be used with dynamic locators
    public static String mealPeriodInput = "NULL";
    public static String mealTypeInput = "NULL";
    public static String mealCategoryInput = "NULL";
    public static String mealDishesInput = "NULL";
}