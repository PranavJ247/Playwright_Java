package stepdefinitions;

import base.PlaywrightFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginSteps {

    private LoginPage loginPage;

    @Given("user launches the application")
    public void userLaunchesApplication() {

        PlaywrightFactory.getPage().navigate(
                "https://opensource-demo.orangehrmlive.com/"
        );

        loginPage = new LoginPage();
    }

    @When("user enters username {string}")
    public void userEntersUsername(String username) {

        loginPage.enterUsername(username);
    }

    @When("user enters password {string}")
    public void userEntersPassword(String password) {

        loginPage.enterPassword(password);
    }
//login step
    @When("user clicks on Login button")
    public void userClicksOnLoginButton() {

        loginPage.clickLogin();
    }

    @Then("user should see the Dashboard")
    public void userShouldSeeDashboard() throws InterruptedException {
        DashboardPage dashboardPage = new DashboardPage();
        Assert.assertTrue(dashboardPage.isDashboardDisplayed());
    }

    @When("user logs out")
    public void userLogsOut() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.logout();
    }

    @Then("user should see the Login page")
    public void userShouldSeeLoginPage() {
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }
}