package Runners.MobileRunners.Android;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/reports/Mobile/Android/cuucmbertestreportSequential.html",
                "json:target/reports/Mobile/Android/cucumberSequential.json"
        },
        features = {"src/test/resources/FeatureFiles/Mobile/Android"},
        glue = {"stepDefinitions/Mobile"},
        tags = "",
        dryRun = false, monochrome = true
)
public class SequentialTestRunnerMobile {
}
