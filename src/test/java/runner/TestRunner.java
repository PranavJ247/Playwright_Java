package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},
        plugin = {
                "pretty"
        },
        tags= "@regression",
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}