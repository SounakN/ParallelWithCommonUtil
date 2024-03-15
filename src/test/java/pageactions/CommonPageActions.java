package pageactions;

import driver.WebBrowserFactory;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.EnvUtil;

import java.time.Duration;
import java.util.Properties;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static stepDefinitions.setUpHook.scenario;
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
        prop = EnvUtil.getProperties();
    }

    @SneakyThrows
    public void goToUrl() {
        driver.get(EnvUtil.getProperty("url"));
    }

    public WebElement clickOnTeams() {
        WebElement teamElement = FindElement(By.xpath(teamLoc), driver, Duration.ofSeconds(30), Duration.ofSeconds(2));
        assertThat(teamElement).isNotNull();
        click(driver, teamElement, Duration.ofSeconds(30));
        embedScreenshot(driver, scenario.get(), "Clicked on Team");
        return teamElement;
    }

    public void logsOut() {
        WebElement teamElement = clickOnTeams();
        WebElement LogoutElement = FindElement(By.xpath(teamDropdownLogoutLoc), teamElement, driver, Duration.ofSeconds(30), Duration.ofSeconds(2));
        assertThat(LogoutElement).isNotNull();
        click(driver, LogoutElement, Duration.ofSeconds(30));
        WebElement loggedOutToastMessageElement = FindElement(By.xpath(loggedOutToastMessageLoc), driver, Duration.ofSeconds(30), Duration.ofSeconds(2));
        assertThat(loggedOutToastMessageElement).isNotNull();
        embedScreenshot(driver, scenario.get(), "Logged Out");
    }

    public void closesModal() {
        WebElement modalClosureElement = FindElement(By.xpath(modalClosureLoc), driver, Duration.ofSeconds(30), Duration.ofSeconds(2));
        assertThat(modalClosureElement).isNotNull();
        click(driver, modalClosureElement, Duration.ofSeconds(30));
        embedText(scenario.get(), "Closed modal");
    }
}