package tests;

import base.BaseTest;
import base.PlaywrightFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLogin() throws InterruptedException {

        // Open Application
        PlaywrightFactory.getPage().navigate("https://opensource-demo.orangehrmlive.com/");

        // Create Page Object
        LoginPage loginPage = new LoginPage();

        // Perform Login
        loginPage.login("Admin", "admin123");

        // Verify Dashboard
        Assert.assertTrue(loginPage.isDashboardDisplayed());

    }
}