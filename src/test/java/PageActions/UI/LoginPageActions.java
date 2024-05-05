package PageActions.UI;

import driver.WebBrowserFactory;
import io.cucumber.java.bs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.ActionMethods;
import utilities.PropertyUtil;

import java.time.Duration;
import java.util.Properties;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static stepDefinitions.UI.setUpHook.scenario;
import static utilities.ActionMethods.*;

public class LoginPageActions {
    //------------------------Locators----------------------------
    private final String emailLoc = "//input[@id='email']";
    private final String passwordLoc = "//input[@id='password']";
    private final String loginButtonLoc = "//button[@id='loginButton']";
    //------------------------Locators----------------------------
    private WebDriver driver;
    private Properties prop;
    ActionMethods<WebDriver> actionMethods ;

    public LoginPageActions(WebBrowserFactory browserFactory) {
        driver = browserFactory.getDriverService();
        prop = PropertyUtil.getProperties();
        actionMethods = new ActionMethods<>();
    }


    public void enterInCredentials() {
        WebElement emailElement = actionMethods.findElement(By.xpath(emailLoc), driver, Duration.ofSeconds(30), Duration.ofSeconds(2));
        assertThat(emailElement).isNotNull();
        assertThat(actionMethods.isClickable(driver, emailElement, Duration.ofSeconds(30))).isTrue();
        actionMethods.type(emailElement, prop.getProperty("userName"));
        WebElement passwordElement = actionMethods.findElement(By.xpath(passwordLoc), driver, Duration.ofSeconds(30), Duration.ofSeconds(2));
        assertThat(passwordElement).isNotNull();
        assertThat(actionMethods.isClickable(driver, passwordElement, Duration.ofSeconds(30))).isTrue();
        actionMethods.type(passwordElement, prop.getProperty("password"));
        embedScreenshot(driver, scenario.get(), "Entered credentials");
    }

    public void login() {
        WebElement loginButtonElement = actionMethods.findElement(By.xpath(loginButtonLoc), driver, Duration.ofSeconds(30), Duration.ofSeconds(2));
        assertThat(loginButtonElement).isNotNull();
        actionMethods.click(driver, loginButtonElement);
    }


}
