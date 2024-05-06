package PageActions.Mobile.Android;


import driver.MobileFactory;

import java.util.function.Supplier;

public class PageObjectInitializationAndroid {
    private static Supplier<LoginPageAndroidActions> loginPageActionsAndroidSupplier = null;

    public static void initializeObjects(MobileFactory mobileFactory) {
        loginPageActionsAndroidSupplier = () -> new LoginPageAndroidActions(mobileFactory);
    }

    public LoginPageAndroidActions loginPageAndroidActions = loginPageActionsAndroidSupplier.get();

}
