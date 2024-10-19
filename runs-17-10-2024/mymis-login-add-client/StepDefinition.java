    package stepdefinitions;

    import implementation.Implementation;
    import io.cucumber.java.en.Given;
    import io.cucumber.java.en.When;
    import io.cucumber.java.en.Then;
    import io.cucumber.java.en.And;

    public class StepDefinition {
        public Implementation implementation = new Implementation();

        @Given("User is on the login page {string}")
        public void userIsOnLoginPage(String url) {
            implementation.launchUrl(url);
        }

        @When("User types user id {string}")
        public void userTypesUserId(String userId) {
            implementation.enterUserId(userId);
        }

        @And("User types password {string}")
        public void userTypesPassword(String password) {
            implementation.enterPassword(password);
        }

        @And("User clicks login button")
        public void userClicksLoginButton() {
            implementation.clickLoginButton();
        }

        @Then("User should be redirected to the dashboard")
        public void userShouldBeRedirectedToDashboard() {
            implementation.verifyDashboardRedirection();
        }

        @Given("User navigates to client management under ec-dc management")
        public void userNavigatesToClientManagement() {
            implementation.navigateToClientManagement();
        }

        @And("User should be redirected to the client management page")
        public void userShouldBeRedirectedToClientManagementPage() {
            implementation.verifyClientManagementPage();
        }

        @When("User clicks on 'Add Client' button")
        public void userClicksOnAddClientButton() {
            implementation.clickAddClientButton();
        }

        @And("User fills in the client name")
        public void userFillsInClientName() {
            implementation.fillClientName();
        }

        @And("User fills in the address")
        public void userFillsInAddress() {
            implementation.fillAddress();
        }

        @And("User fills in the city")
        public void userFillsInCity() {
            implementation.fillCity();
        }

        @And("User fills in the country")
        public void userFillsInCountry() {
            implementation.fillCountry();
        }

        @And("User clicks 'Add' button")
        public void userClicksAddButton() {
            implementation.clickAddButton();
        }

        @Then("User should be redirected to the manage client page")
        public void userShouldBeRedirectedToManageClientPage() {
            implementation.verifyManageClientPageRedirection();
        }

        @Then("close the browser")
        public void closeBrowser() {
            implementation.closeBrowser();
        }
    }