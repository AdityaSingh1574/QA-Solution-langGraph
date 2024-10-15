    package stepdefinitions;

    import implementation.Implementation;
    import io.cucumber.java.en.Given;
    import io.cucumber.java.en.When;
    import io.cucumber.java.en.Then;

    public class StepDefinition {
        private Implementation implementation = new Implementation();

        @Given("User is on the login page {string}")
        public void userIsOnLoginPage(String url) {
            implementation.launchUrl(url);
        }

        @When("User enters user id {string}")
        public void userEntersUserId(String userId) {
            implementation.enterUserId(userId);
        }

        @When("User enters password {string}")
        public void userEntersPassword(String password) {
            implementation.enterPassword(password);
        }

        @When("User clicks on the login button")
        public void userClicksOnLoginButton() {
            implementation.clickLoginButton();
        }

        @Then("User should be redirected to the MIS homepage")
        public void userShouldBeRedirectedToMISHomepage() {
            implementation.verifyMISHomepage();
        }

        @Given("User navigates to team info under team management")
        public void userNavigatesToTeamInfo() {
            implementation.navigateToTeamInfo();
        }

        @Then("User should be redirected to the Team Information page")
        public void userShouldBeRedirectedToTeamInformationPage() {
            implementation.verifyTeamInformationPage();
        }

        @When("User enters team name as {string}")
        public void userEntersTeamName(String teamName) {
            implementation.enterTeamName(teamName);
        }

        @When("User selects weak start day as {string} from the dropdown")
        public void userSelectsWeekStartDay(String weekStartDay) {
            implementation.selectWeekStartDay(weekStartDay);
        }

        @When("User selects department as {string} from the dropdown")
        public void userSelectsDepartment(String department) {
            implementation.selectDepartment(department);
        }

        @When("User selects team head as {string} from the dropdown")
        public void userSelectsTeamHead(String teamHead) {
            implementation.selectTeamHead(teamHead);
        }

        @When("User clicks on the save button")
        public void userClicksOnSaveButton() {
            implementation.clickSaveButton();
        }

        @Then("The new team should be created successfully")
        public void newTeamShouldBeCreatedSuccessfully() {
            implementation.verifyTeamCreation();
        }

        @Then("close the browser")
        public void closeBrowser() {
            implementation.closeBrowser();
        }
    }