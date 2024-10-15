// filename: FlightSearchLocators.java

import org.openqa.selenium.By;

public class FlightSearchLocators {
    public static final By FROM_DROPDOWN = By.xpath("//label[contains(text(), 'From')]");
    public static final By TO_DROPDOWN = By.xpath("//label[contains(text(), 'To')]");
    public static final By DATE_PICKER = By.xpath("//label[contains(text(), 'Departure Date')]");
    public static final By SEARCH_BUTTON = By.xpath("//div[contains(text(), 'FLIGHTS')]");
    public static final By DURATION_COLUMN_HEADER = By.xpath("//span[contains(text(), 'Duration')]");
}