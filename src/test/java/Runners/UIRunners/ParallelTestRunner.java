package Runners.UIRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/reports/UI/CucumberTestReportUiParallel.html",
                "json:target/reports/UI/CucumberTestReportUiParallel.json"
        },
        features = {"src/test/resources/FeatureFiles/UI/FeatureFileParallel"},
        glue = {"stepDefinitions/UI"},
        tags = "",
        dryRun = false, monochrome = true
)
public class ParallelTestRunner {
}
