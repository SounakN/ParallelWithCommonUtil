package Runners.UIRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/reports/UI/CucumberTestReportUiSequential.html",
                "json:target/reports/UI/CucumberTestReportUiSequential.json"
        },
        features = {"src/test/resources/FeatureFiles/UI/FeatureFileSequential"},
        glue = {"stepDefinitions/UI"},
        tags = "@Web",
        dryRun = false, monochrome = true
)
public class SequentialTestRunner {
}
