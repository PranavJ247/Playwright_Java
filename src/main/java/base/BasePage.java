package base;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BasePage {

    protected static Page page;

    public BasePage() {
        page = PlaywrightFactory.getPage();

    }

    public void click(Locator locator) {
        locator.click();
    }
//Enter values
    public void fill(Locator locator, String value) {
        locator.fill(value);
    }

    public String getText(Locator locator) {
        return locator.textContent();
    }

    public static boolean isVisible(Locator locator) {
        return locator.isVisible();
    }

    public void waitForVisible(Locator locator) {
        locator.waitFor();
    }

    public String getTitle() {
        return page.title();
    }

    public String getURL() {
        return page.url();
    }
}
