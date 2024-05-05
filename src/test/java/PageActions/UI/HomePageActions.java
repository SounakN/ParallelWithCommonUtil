package PageActions.UI;

import driver.WebBrowserFactory;
import io.cucumber.java.bs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.ActionMethods;
import utilities.PropertyUtil;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static stepDefinitions.UI.setUpHook.scenario;
import static utilities.ActionMethods.*;

public class HomePageActions {
    private String bannerShadowLoc = "//div[@class='banner-shadow']";
    private String bannerListWithDropdowns = "//ul[contains(@class,'navbar-nav')]/li/div";
    private String modalContentLoc = "//div[@class='modal-content']";
    private String headerValueModalLoc = "//div[@class='modal-body']//h5";
    private String teamDropdownLoc = "./following-sibling::div/div[text()='%s']";
    private String settingsPageHeaderLoc = "//h1[text()='Access']";
    private WebDriver driver = null;
    private Properties prop = null;
    ActionMethods<WebDriver> actionMethods ;

    public HomePageActions(WebBrowserFactory browserFactory) {
        driver = browserFactory.getDriverService();
        prop = PropertyUtil.getProperties();
        actionMethods = new ActionMethods<>();
    }

    public void verifyPage() {
        WebElement bannerShadowElement = actionMethods.findElement(By.xpath(bannerShadowLoc), driver, Duration.ofSeconds(30), Duration.ofSeconds(2));
        assertThat(bannerShadowElement).isNotNull();
        embedScreenshot(driver, scenario.get(), "Landed in Home Page");
    }

    public void clicksOnSectionWithDropdown(String sectionValue) {
        List<WebElement> bannerListWithDropdownsElement = actionMethods.findElements(By.xpath(bannerListWithDropdowns), driver, Duration.ofSeconds(30), Duration.ofSeconds(2));
        assertThat(bannerListWithDropdownsElement).isNotNull();
        WebElement sectionChoice = returnWebElementFromList(bannerListWithDropdownsElement, sectionValue);
        assertThat(sectionChoice).isNotNull();
        actionMethods.click(driver, sectionChoice);
        WebElement modalContentElement = actionMethods.findElement(By.xpath(modalContentLoc), driver, Duration.ofSeconds(30), Duration.ofSeconds(2));
        assertThat(modalContentElement).isNotNull();
        embedScreenshot(driver, scenario.get(), "Modal Content opened");
    }

    public void checkHeaderPresence(String headerValue) {
        List<WebElement> headerList = actionMethods.findElements(By.xpath(headerValueModalLoc), driver, Duration.ofSeconds(30), Duration.ofSeconds(2));
        assertThat(headerList.size()).isNotZero();
        List<String> headerValues = new ArrayList<>();
        headerList.forEach(elements -> {
            headerValues.add(elements.getText());
        });
        Arrays.stream(headerValue.split(",")).forEach(headerVal -> {
            embedText(scenario.get(), "From the list of Headers extracted :: " + headerValues + " with the expected value :: " + headerVal);
            assertThat(headerValues.contains(headerVal)).isTrue();
        });
    }

    public void chooseAndClickOnTeamsMenu(String teamsMenu, WebElement teamsWebElement) {
        WebElement LogoutElement = actionMethods.findElement(By.xpath(String.format(teamDropdownLoc, teamsMenu)), teamsWebElement, driver, Duration.ofSeconds(30), Duration.ofSeconds(2));
        assertThat(LogoutElement).isNotNull();
        actionMethods.click(driver, LogoutElement);

        switch (teamsMenu) {
            case "SETTINGS":
                WebElement settingsPageHeaderElement = actionMethods.findElement(By.xpath(settingsPageHeaderLoc), driver, Duration.ofSeconds(30), Duration.ofSeconds(2));
                assertThat(settingsPageHeaderElement).isNotNull();
                embedScreenshot(driver, scenario.get(), "Landed in Settings page");
                break;
            default:
                break;
        }
    }
}
