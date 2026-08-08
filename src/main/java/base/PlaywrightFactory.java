package base;

import com.microsoft.playwright.*;
import utils.ConfigReader;

public class PlaywrightFactory {

    private static final ThreadLocal<Playwright> playwright = new ThreadLocal<>();
    private static final ThreadLocal<Browser> browser = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> context = new ThreadLocal<>();
    private static final ThreadLocal<Page> page = new ThreadLocal<>();

    public static void initBrowser() {

        Playwright pw = Playwright.create();
        playwright.set(pw);

        BrowserType.LaunchOptions options =
                new BrowserType.LaunchOptions();

        boolean headless = Boolean.parseBoolean(
                ConfigReader.getProperty("headless")
        );

        options.setHeadless(headless);

        String browserName =
                ConfigReader.getProperty("browser");

        switch (browserName.toLowerCase()) {

            case "chromium":
                browser.set(pw.chromium().launch(options));
                break;

            case "firefox":
                browser.set(pw.firefox().launch(options));
                break;

            case "webkit":
                browser.set(pw.webkit().launch(options));
                break;

            default:
                throw new RuntimeException(
                        "Invalid browser: " + browserName
                );
        }

        context.set(browser.get().newContext());
        page.set(context.get().newPage());
    }

    public static Page getPage() {
        return page.get();
    }

    public static void closeBrowser() {

        try {
            if (page.get() != null) {
                page.get().close();
            }
        } finally {
            page.remove();
        }

        try {
            if (context.get() != null) {
                context.get().close();
            }
        } finally {
            context.remove();
        }

        try {
            if (browser.get() != null) {
                browser.get().close();
            }
        } finally {
            browser.remove();
        }

        try {
            if (playwright.get() != null) {
                playwright.get().close();
            }
        } finally {
            playwright.remove();
        }
    }
}