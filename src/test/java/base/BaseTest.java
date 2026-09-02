package base;

import com.microsoft.playwright.Page;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.nio.file.Paths;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        PlaywrightFactory.initBrowser();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {

            Page page = PlaywrightFactory.getPage();

            String testName = result.getMethod().getMethodName();

            page.screenshot(
                    new Page.ScreenshotOptions()
                            .setPath(Paths.get(
                                    "target/screenshots/" + testName + ".png"
                            ))
                            .setFullPage(true)
            );
        }

        PlaywrightFactory.closeBrowser();
    }
}