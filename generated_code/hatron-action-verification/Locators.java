// filename: Locators.java

import org.openqa.selenium.By;

public class Locators {
    // Action button
    public static final By ACTION_BUTTON = By.xpath("//*[@id=\"font-size\"]/athena-action/p-button/button");

    // Candidate report button
    public static final By CANDIDATE_REPORT_BUTTON = By.xpath("//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/div/div/div/p-table/div[2]/div/div[1]");

    // Test summary button
    public static final By TEST_SUMMARY_BUTTON = By.xpath("//*[@id=\"p-tabpanel-0\"]/athena-placement-drives/div/div/div/p-table/div[2]/div/div[2]");

    // Evaluate candidate button
    public static final By EVALUATE_CANDIDATE_BUTTON = null; // This XPath is set to null as per the given JSON
}