package PageActions.UI;

import driver.WebBrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public LoginPageActions(WebBrowserFactory browserFactory) {
        driver = browserFactory.getDriverService();
        prop = PropertyUtil.getProperties();
    }


    public void enterInCredentials() {
        WebElement emailElement = findElement(By.xpath(emailLoc), driver, Duration.ofSeconds(30), Duration.ofSeconds(2));
        assertThat(emailElement).isNotNull();
        assertThat(isClickable(driver, emailElement, Duration.ofSeconds(30))).isTrue();
        type(emailElement, prop.getProperty("userName"));
        WebElement passwordElement = findElement(By.xpath(passwordLoc), driver, Duration.ofSeconds(30), Duration.ofSeconds(2));
        assertThat(passwordElement).isNotNull();
        assertThat(isClickable(driver, passwordElement, Duration.ofSeconds(30))).isTrue();
        type(passwordElement, prop.getProperty("password"));
        embedScreenshot(driver, scenario.get(), "Entered credentials");
    }

    public void login() {
        WebElement loginButtonElement = findElement(By.xpath(loginButtonLoc), driver, Duration.ofSeconds(30), Duration.ofSeconds(2));
        assertThat(loginButtonElement).isNotNull();
        click(driver, loginButtonElement, Duration.ofSeconds(30));
    }


}
