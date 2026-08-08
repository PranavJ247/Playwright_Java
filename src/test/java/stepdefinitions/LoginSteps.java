package stepdefinitions;

import base.PlaywrightFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
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

    @When("user clicks on Login button")
    public void userClicksOnLoginButton() {

        loginPage.clickLogin();
    }

    @Then("user should see the Dashboard")
    public void userShouldSeeDashboard() throws InterruptedException {

        Assert.assertTrue(loginPage.isDashboardDisplayed());
    }
}