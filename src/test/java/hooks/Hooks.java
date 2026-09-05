package hooks;

import base.PlaywrightFactory;
import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Hooks {

    @Before
    public void setUp() {
        PlaywrightFactory.initBrowser();
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            System.out.println("===== SCREENSHOT CODE STARTED =====");
            Page page = PlaywrightFactory.getPage();

            try {
                Path screenshotDirectory =
                        Paths.get("target/screenshots");

                Files.createDirectories(screenshotDirectory);

                String fileName = scenario.getName()
                        .replaceAll("[^a-zA-Z0-9-_]", "_");

                Path screenshotPath =
                        screenshotDirectory.resolve(fileName + ".png");

                page.screenshot(
                        new Page.ScreenshotOptions()
                                .setPath(screenshotPath)
                                .setFullPage(true)
                );
                System.out.println("===== SCREENSHOT CREATED =====");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        PlaywrightFactory.closeBrowser();
    }
}