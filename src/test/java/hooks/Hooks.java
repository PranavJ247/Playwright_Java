package hooks;

import base.PlaywrightFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() {
        PlaywrightFactory.initBrowser();
    }

    @After
    public void tearDown() {
        PlaywrightFactory.closeBrowser();
    }
}