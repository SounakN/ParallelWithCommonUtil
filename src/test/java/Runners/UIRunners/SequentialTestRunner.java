package Runners.UIRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/reports/cuucmbertestreportSequential.html",
                "json:target/reports/cucumberSequential.json"
        },
        features = {"src/test/resources/FeatureFiles/FeatureFileSequential"},
        glue = {"stepDefinitions"},
        tags = "",
        dryRun = false, monochrome = true
)
public class SequentialTestRunner {
}