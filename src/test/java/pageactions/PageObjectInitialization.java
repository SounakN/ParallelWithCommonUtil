package pageactions;

import driver.WebBrowserFactory;

import java.util.function.Supplier;

public class PageObjectInitialization {
    private static Supplier<LoginPageActions> loginPageActionsSupplier = null;
    private static Supplier<HomePageActions> homePageActionsSupplier = null;
    private static Supplier<CommonPageActions> commonPageActionsSupplier = null;
    private static Supplier<TeamsPageActions> teamsPageActionsSupplier = null;

    public static void initializeObjects(WebBrowserFactory browserFactory) {
        loginPageActionsSupplier = () -> new LoginPageActions(browserFactory);
        homePageActionsSupplier = () -> new HomePageActions(browserFactory);
        commonPageActionsSupplier = () -> new CommonPageActions(browserFactory);
        teamsPageActionsSupplier = () -> new TeamsPageActions(browserFactory);
    }

    public LoginPageActions loginPageActions = loginPageActionsSupplier.get();
    public HomePageActions homePageActions = homePageActionsSupplier.get();
    public CommonPageActions commonPageActions = commonPageActionsSupplier.get();
    public TeamsPageActions teamsPageActions = teamsPageActionsSupplier.get();

}
