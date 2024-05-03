package PageActions.Mobile.Android;

import PageActions.UI.CommonPageActions;
import PageActions.UI.HomePageActions;
import PageActions.UI.LoginPageActions;
import PageActions.UI.TeamsPageActions;
import driver.WebBrowserFactory;

import java.util.function.Supplier;

public class PageObjectInitialization {
    private static Supplier<LoginPageActions> loginPageActionsSupplier = null;

    public static void initializeObjects(WebBrowserFactory browserFactory) {
        loginPageActionsSupplier = () -> new LoginPageActions(browserFactory);
    }

    public LoginPageActions loginPageActions = loginPageActionsSupplier.get();

}
