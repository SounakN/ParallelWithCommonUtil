package PageActions.Mobile.Android;

import driver.MobileFactory;
import driver.WebBrowserFactory;
import io.appium.java_client.AppiumDriver;
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
  private final String loginButtonLoc ="//android.widget.TextView[@text='LOGIN']";
    //------------------------Locators----------------------------
    private AppiumDriver driver;
    private Properties prop;

    public LoginPageActions(WebBrowserFactory browserFactory) {
        driver = MobileFactory.getDriverService();
        prop = PropertyUtil.getProperties();
    }

    public void clickOnLoginButton(){

    }





}
