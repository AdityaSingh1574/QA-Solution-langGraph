// filename: WeatherPageLocators.java

import org.openqa.selenium.By;

public class WeatherPageLocators {
    public static final By SEARCH_INPUT = By.xpath("//input[@name='query']");
    public static final By LOCATION_INPUT = By.xpath("//input[@name='query']");
    public static final By SEARCH_BUTTON = By.xpath("//input[@name='query']");
    public static final By ADDRESS_CITY_ZIP_INPUT = By.xpath("//input[@name='query']");
    public static final By TODAY_LINK = By.xpath("(//a[@href='/en/in/new-delhi/187745/weather-forecast/187745'])[1]");
}