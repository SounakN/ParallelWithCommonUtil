package stepDefinitions.Mobile.Android;

import PageActions.Mobile.Android.PageObjectInitializationAndroid;
import PageActions.UI.PageObjectInitialization;
import io.cucumber.java.en.Given;

public class testStepDefinition {
    private PageObjectInitializationAndroid pageObjectInitialization = null;

    public testStepDefinition(PageObjectInitializationAndroid pageObjectInitialization) {
        this.pageObjectInitialization = pageObjectInitialization;
    }
    @Given("that the app launches")
    public void thatTheAppLaunches() {

    }
}
