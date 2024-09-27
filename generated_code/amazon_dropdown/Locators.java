// filename: AmazonLocators.java

import org.openqa.selenium.By;

public class AmazonLocators {
    // Search elements
    public static final By SEARCH_INPUT_BOX = By.xpath("//*[@id=\"twotabsearchtextbox\"]");
    public static final By SEARCH_BUTTON = By.xpath("//*[@id=\"nav-search-submit-button\"]");

    // Search results
    public static final By SEARCH_RESULT_1 = By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div[2]/div[2]/div[2]/h2/span");
    public static final By SEARCH_RESULT_2 = By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[4]/div/div/div/div/span/div/div/div[2]/div[2]/div[2]/h2/span");
    public static final By SEARCH_RESULT_3 = By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[5]/div/div/div/div/span/div/div/div[2]/div[2]/div[2]/h2/span");
    public static final By SEARCH_RESULT_4 = By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[6]/div/div/div/div/span/div/div/div[2]/div[2]/div[2]/h2/span");
    public static final By SEARCH_RESULT_5 = By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[7]/div/div/div/div/span/div/div/div[2]/div[2]/div[2]/h2/span");
}