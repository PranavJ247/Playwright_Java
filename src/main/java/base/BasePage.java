package base;

import com.microsoft.playwright.Page;

public class BasePage {

    protected Page page;

    public BasePage() {
        page = PlaywrightFactory.getPage();

    }

    public void click(String locator) {

    }

    public void fill(String locator, String value) {

    }

    public String getText(String locator) {
        return null;
    }

    public boolean isVisible(String locator) {
        return false;
    }

    public void waitForVisible(String locator) {

    }

    public String getTitle() {
        return null;
    }

    public String getURL() {
        return null;
    }
}
