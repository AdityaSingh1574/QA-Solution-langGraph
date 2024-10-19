GENERATION_PROMPT_LOCATORS = """
    You will be given xpaths of web elements as input for which a locator file is to be generated for the purpose of testing.
    Your task will be to generate a locator file in JAVA which will be required for automation testing.
    
    the following are the xpaths given between `---XPATH-START---` and `---XPATH-END---`
    
    ---XPATH-START---
    {xpath_string}
    ---XPATH-END----
  
    Important instructions:
    1. Add necessary import statements. 
    2. Return the code between the separators `---JAVA-CODE---` and `---JAVA-CODE---` only
    3. Return only the code between the separators nothing else.
    The following is an example of Locators file to be generated:
    
    package locators;
    public class Locators {{
        public static By loginButton = By.xpath("//span[text()='Login with Gemini mail!']");
        public static By firstName = By.xpath("//input[contains(@class,'first-name')]");
        public static String textField = "//input[@id='email']";
    }}
    """
    
    
GENERATION_PROMPT_STD_IMP = """
        ---FEATURE-FILE-START---
        {feature_file_text}
        ---FEATURE-FILE-END---

        the feature file is given between `---FEATURE-FILE-START---` and `---FEATURE-FILE-END---`
        Your task will be to implement the step definition file using the above given feature file text in JAVA

        You can use the following instructions for generating step definition and implementation files
        1. Go through and understand the text of the feature file to comprehend the steps that need to be implemented.
        2. Step definition file will contain the Python code that defines the steps for the feature file text 
        3. the implementation file will contain the actual implementation of the test case / feature file containing the imports from step definition file.
        4. Divide feature file big task into small steps / tasks and implement the functions for getting the steps done
        5. Implement all the functions in the implementation and step definition files for completing the task

        use the following locator files text  for implementing the step definition file for accessing the element 
        The Xpaths are given between `---LOCATOR-FILE-START---` and `---LOCATOR-FILE-END---`

        ---LOCATOR-FILE-START---
        {locator_file_text}
        ---LOCATOR-FILE-END---

        The following can be used as an example for a step definition file
        package stepdefinitions;
        import implementation.Implementation;
        import io.cucumber.java.en.Given;
        import io.cucumber.java.en.When;
        import io.cucumber.java.en.Then;

        public class StepDefinition {{
            public Implementation implementation = new Implementation();

            @Given("the user is on the home page")
            public void launchUrl(){{
                implementation.launchUrl(url);
            }}

            @When("the user clicks on login button")
                public void userClicksOnLoginButton() {{
                    implementation.clickOnLoginButton();
            }}

            @Then("username and password fields should appear")
                public void verifyLoginWindowAppears() {{
                    implementation.verifyLoginElements();
            }}

            @Then("close the browser")
            public void closeBrowser(){{
                implementation.closeBrowser();
            }}
        }}

        Important instructions:
        1. The Xpaths given are accurate hence do not generate on your own
        2. Do not use chromedriver.exe for accessing the browser instead use WebDriverManager library for the same. 
        3. Include waiting time if the code needs to redirect to some other page and a wait time is required for successful code execution
        4. Use WebDriverWait to ensure that the element is clickable before interacting with it.
        5. If the element takes time to be present on the DOM before becoming clickable, first wait for the presence of the element, then check if it's clickable.Use ExpectedConditions.presenceOfElementLocated Before clickable.
        6. The element may not be visible immediately after being loaded in the DOM. You can first check if the element is present in the DOM and then wait for its visibility.Use presenceOfElementLocated Before visibilityOfElementLocated
        7. While generating the code for the functions in implementation file make sure to first make an instance of the elements and then perform actions using methods for the instance.
        You can use the following example for reference
        public void navigateToTeamInfo() {{
            WebElement teamManagementElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.teamManagementSpan));
            teamManagementElement.click();
            WebElement teamInfoElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.teamInformationLink));
            teamInfoElement.click();
        }}
        8. Add a wait to make sure the page or particular elements are fully loaded before trying to click.
        9. Ensure the step definition file contains launchUrl and closeBrowser methods.
        10. Keep the JAVA code for implementation file between separators `---IMPLEMENTATION-FILE-START---` and `---IMPLEMENTATION-FILE-END---`
        11. Keep the JAVA code for step-definition file between separators `---STEP-DEFINITION-FILE-START---` and `---STEP-DEFINITION-FILE-END---`
        12. Return only the JAVA code with the separators and nothing else.
        13. include the package lines: package stepdefinitions and package implementations in relevant file codes
        14. The class names have to be strictly the names : StepDefinition and Implementation in relevant file codes
        """