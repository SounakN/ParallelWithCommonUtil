package Runners.MobileRunners.Android;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/reports/Mobile/Android/CucumberMobileAndroidReport.html",
                "json:target/reports/Mobile/Android/CucumberMobileAndroidReport.json"
        },
        features = {"src/test/resources/FeatureFiles/Mobile/Android"},
        glue = {"stepDefinitions/Mobile/Android"},
        tags = "@MobileAndroid",
        dryRun = false, monochrome = true
)
public class SequentialTestRunnerMobileAndroid {
}
