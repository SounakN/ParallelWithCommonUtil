package PageActions.Mobile.Android;


import driver.MobileFactory;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.WebDriver;
import utilities.ActionMethods;

import java.util.function.Supplier;

public class PageObjectInitialization {
    private static Supplier<LoginPageActions> loginPageActionsSupplier = null;

    public static void initializeObjects(MobileFactory mobileFactory) {
        loginPageActionsSupplier = () -> new LoginPageActions(mobileFactory);
    }

    public LoginPageActions loginPageActions = loginPageActionsSupplier.get();

}
