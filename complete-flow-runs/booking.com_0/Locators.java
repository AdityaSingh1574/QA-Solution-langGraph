import org.openqa.selenium.By;

public class HotelBookingLocators {
    // Search page locators
    public static final By DESTINATION_SEARCH_FIELD = By.xpath("//input[@id=':rh:']");
    public static final By CHECKIN_DATE_BUTTON = By.xpath("//button[contains(text(), 'Check-in Date')]");
    public static final By CHECKOUT_DATE_BUTTON = By.xpath("//button[contains(text(), 'Check-out Date')]");
    public static final By SEARCH_BUTTON = By.xpath("//button[contains(text(), 'Search')]");

    // Search results page locators
    public static final By HOTEL_LIST = By.xpath("//div[contains(text(), 'Search results')]");
    public static final By TOP_RESULT_HOTEL = null;  // This is set to null as the original had "NULL" for this field
    public static final By SEE_AVAILABILITY_BUTTON = By.xpath("//button[contains(text(), 'Show prices')]");
}