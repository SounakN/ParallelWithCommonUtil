package Runners.UIRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/reports/cuucmbertestreportParallel.html",
                "json:target/reports/cucumberParallel.json"
        },
        features = {"src/test/resources/FeatureFiles/UI/FeatureFileParallel"},
        glue = {"stepDefinitions"},
        tags = "",
        dryRun = false, monochrome = true
)
public class ParallelTestRunner {
}
