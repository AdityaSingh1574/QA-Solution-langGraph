// filename: Locators.java

import org.openqa.selenium.By;

public class Locators {
    // Search input field
    public static final By SEARCH_INPUT = By.xpath("//input[@aria-label='Search']");
    
    // Search icon button
    public static final By SEARCH_ICON_BUTTON = By.xpath("//button[@aria-label='Search icon']");
    
    // Add to cart button (NULL in the provided JSON)
    public static final By ADD_TO_CART_BUTTON = null;
    
    // View cart button (NULL in the provided JSON)
    public static final By VIEW_CART_BUTTON = null;
}