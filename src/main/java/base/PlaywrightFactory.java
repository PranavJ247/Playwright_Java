package base;

import com.microsoft.playwright.*;

public class PlaywrightFactory {

    private static ThreadLocal<Playwright> playwright = new ThreadLocal<>();
    private static ThreadLocal<Browser> browser = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> context = new ThreadLocal<>();
    private static ThreadLocal<Page> page = new ThreadLocal<>();

    public static void initBrowser() {
        playwright.set(Playwright.create());
        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions();
        options.setHeadless(false);

        // Launch Browser
        browser.set(
                playwright.get().chromium().launch(options)
        );
        context.set(
                browser.get().newContext()
        );
        page.set(
                context.get().newPage()
        );
    }
    public static Page getPage() {
        return page.get();
    }

    public static void closeBrowser() {

        if (page.get() != null) {
            page.get().close();
            page.remove();
        }

        if (context.get() != null) {
            context.get().close();
            context.remove();
        }

        if (browser.get() != null) {
            browser.get().close();
            browser.remove();
        }

        if (playwright.get() != null) {
            playwright.get().close();
            playwright.remove();
        }
    }
}
