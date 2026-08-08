package pages;
import base.BasePage;
import com.microsoft.playwright.Locator;
public class LoginPage extends BasePage {
    public LoginPage() {
        super();
    }
    private Locator txtUsername = page.locator("input[name='username']");
    private Locator txtPassword = page.locator("input[name='password']");
    private Locator btnLogin = page.locator("button[type='submit']");
    private Locator lblDashboard = page.locator("//h6[text()='Dashboard']");

    public void login(String username, String password) {
        fill(txtUsername, username);

        fill(txtPassword, password);

        click(btnLogin);
    }

    public boolean isDashboardDisplayed() throws InterruptedException {
        waitForVisible(lblDashboard);
        page.waitForTimeout(5000);
        return isVisible(lblDashboard);

    }


    public void enterUsername(String username) {
        fill(txtUsername, username);
    }

    public void enterPassword(String password) {
        fill(txtPassword, password);
    }

    public void clickLogin() {
        click(btnLogin);
    }
}
