package tests;

import base.BaseTest;
import base.PlaywrightFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLogin() throws InterruptedException {

        // Open the Application
        PlaywrightFactory.getPage().navigate(ConfigReader.getProperty("url"));

        // Create Page Object
        LoginPage loginPage = new LoginPage();

        // Perform Login in Application
        loginPage.login("Admin", "admin123");

        DashboardPage dashboardPage = new DashboardPage();

        //Assert.assertTrue(dashboardPage.isDashboardDisplayed());
        Assert.assertTrue(dashboardPage.isDashboardDisplayed());

    }
}