package pageactions;

import driver.WebBrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.PropertyUtil;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static Constants.ConstantsForTeamsSettings.teamSettingsMapping;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static stepDefinitions.setUpHook.scenario;
import static utilities.ActionMethods.FindElement;
import static utilities.ActionMethods.embedText;

public class TeamsPageActions {

    private WebDriver driver = null;
    private Properties prop = null;

    public TeamsPageActions(WebBrowserFactory browserFactory) {
        driver = browserFactory.getDriverService();
        prop = PropertyUtil.getProperties();
    }

    public void assertUserDataFromSettings(Map<String, String> data) {
        HashMap<String, String> mapValues = teamSettingsMapping;
        data.forEach((key, value) -> {
            WebElement inputValue = FindElement(By.xpath(String.format("//input[@id='%s']", mapValues.get(key))), driver, Duration.ofSeconds(30), Duration.ofSeconds(2));
            assertThat(inputValue).isNotNull();
            String textExtracted = inputValue.getAttribute("value");
            embedText(scenario.get(), "Found the extracted text value :: " + textExtracted + " and matching it with the actual value :: " + value + " for the section :: " + key);
            assertThat(textExtracted).isEqualTo(value);

        });

    }
}
