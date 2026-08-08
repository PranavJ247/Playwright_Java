package pages;

import base.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;

public class DashboardPage extends BasePage {

    private static Locator dashboardTitle =
            page.locator("//h6[text()='Dashboard']");

    private Locator userDropdown =
            page.locator("//span[@class='oxd-userdropdown-tab']");

    private Locator logoutLink =
            page.locator("//a[text()='Logout']");

    public static boolean isDashboardDisplayed() {
        dashboardTitle.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE));
        return isVisible(dashboardTitle);
    }

    public void logout() {
        click(userDropdown);
        click(logoutLink);
    }
}