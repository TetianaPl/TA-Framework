package cucumber.testrunners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/cucumber/features"},
        glue = {"stepdefinitions", "hooks"},
        plugin = {"pretty"})
public class FillComputeEngineCalculatorTest {
}
