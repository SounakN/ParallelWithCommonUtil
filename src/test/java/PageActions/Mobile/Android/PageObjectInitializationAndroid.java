package PageActions.Mobile.Android;


import driver.MobileFactory;

import java.util.function.Supplier;

public class PageObjectInitializationAndroid {
    private static Supplier<LoginPageActions> loginPageActionsSupplier = null;

    public static void initializeObjects(MobileFactory mobileFactory) {
        loginPageActionsSupplier = () -> new LoginPageActions(mobileFactory);
    }

    public LoginPageActions loginPageActions = loginPageActionsSupplier.get();

}
