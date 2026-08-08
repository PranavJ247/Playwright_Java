package pages;

import base.BasePage;
import com.microsoft.playwright.Locator;

public class DashboardPage extends BasePage {

    private Locator dashboardTitle =
            page.locator("//h6[text()='Dashboard']");

    private Locator userDropdown =
            page.locator("//span[@class='oxd-userdropdown-tab']");

    private Locator logoutLink =
            page.locator("//a[text()='Logout']");

    public boolean isDashboardDisplayed() {

        dashboardTitle.waitFor();

        return isVisible(dashboardTitle);
    }

    public void logout() {

        click(userDropdown);
        click(logoutLink);
    }
}