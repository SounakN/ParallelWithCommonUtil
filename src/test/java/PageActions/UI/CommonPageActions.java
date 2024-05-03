package PageActions.UI;

import driver.WebBrowserFactory;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.PropertyUtil;

import java.time.Duration;
import java.util.Properties;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static stepDefinitions.UI.setUpHook.scenario;
import static utilities.ActionMethods.*;

public class CommonPageActions {
    private String modalClosureLoc = "//*[@class='modal-title']/span";
    private String teamLoc = "//ul[contains(@class,'navbar-nav')]/li/a[text()='Team']";
    private String teamDropdownLogoutLoc = "./following-sibling::div/div[text()='LOGOUT']";
    private String loggedOutToastMessageLoc = "//div[@role='alert']/div[text()='You have been logged out.']";
    public WebBrowserFactory BrowserFactory = null;
    private WebDriver driver;
    private Properties prop = null;

    public CommonPageActions(WebBrowserFactory browserFactory) {
        this.BrowserFactory = browserFactory;
        driver = browserFactory.getDriverService();
        prop = PropertyUtil.getProperties();
    }

    @SneakyThrows
    public void goToUrl() {
        driver.get(PropertyUtil.getProperty("url"));
    }

    public WebElement clickOnTeams() {
        WebElement teamElement = findElement(By.xpath(teamLoc), driver, Duration.ofSeconds(30), Duration.ofSeconds(2));
        assertThat(teamElement).isNotNull();
        click(driver, teamElement, Duration.ofSeconds(30));
        embedScreenshot(driver, scenario.get(), "Clicked on Team");
        return teamElement;
    }

    public void logsOut() {
        WebElement teamElement = clickOnTeams();
        WebElement LogoutElement = findElement(By.xpath(teamDropdownLogoutLoc), teamElement, driver, Duration.ofSeconds(30), Duration.ofSeconds(2));
        assertThat(LogoutElement).isNotNull();
        click(driver, LogoutElement, Duration.ofSeconds(30));
        WebElement loggedOutToastMessageElement = findElement(By.xpath(loggedOutToastMessageLoc), driver, Duration.ofSeconds(30), Duration.ofSeconds(2));
        assertThat(loggedOutToastMessageElement).isNotNull();
        embedScreenshot(driver, scenario.get(), "Logged Out");
    }

    public void closesModal() {
        WebElement modalClosureElement = findElement(By.xpath(modalClosureLoc), driver, Duration.ofSeconds(30), Duration.ofSeconds(2));
        assertThat(modalClosureElement).isNotNull();
        click(driver, modalClosureElement, Duration.ofSeconds(30));
        embedText(scenario.get(), "Closed modal");
    }
}
