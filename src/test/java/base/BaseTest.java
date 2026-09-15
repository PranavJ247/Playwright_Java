package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        PlaywrightFactory.initBrowser();
    }
//close browser
    @AfterMethod
    public void tearDown() {
        PlaywrightFactory.closeBrowser();
    }
}