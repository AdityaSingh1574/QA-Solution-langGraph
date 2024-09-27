// filename: PlacementDriveLocators.java

import org.openqa.selenium.By;

public class PlacementDriveLocators {
    public static final By START_DATE_SELECTION_BUTTON = By.xpath("//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/div/div/div/p-table/div/div[1]/div/div[2]/span/p-calendar/span/button");
    public static final By END_DATE_SELECTION_BUTTON = By.xpath("//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/div/div/div/p-table/div/div[1]/div/div[3]/span/p-calendar/span/button");
    public static final By START_DATE_TARGET = By.xpath("/html/body/div/div[1]/div/div[2]/table/tbody/tr[1]/td[1]");
    public static final By END_DATE_TARGET = By.xpath("/html/body/div/div[1]/div/div[2]/table/tbody/tr[5]/td[2]");
    public static final By COURSE_COUNTER = By.xpath("//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/div/div/div/div[2]/div[1]/span");
}