package stepDefinitions.Mobile.Android;

import PageActions.Mobile.Android.PageObjectInitializationAndroid;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class LoginPageStepDefinitions {
    private PageObjectInitializationAndroid pageObjectInitialization = null;

    public LoginPageStepDefinitions(PageObjectInitializationAndroid pageObjectInitialization) {
        this.pageObjectInitialization = pageObjectInitialization;
    }
    @Given("that the app launches")
    public void thatTheAppLaunches() {

    }

    @Given("User launches the App and enters mobile number")
    public void userLaunchesTheAppAndEntersMobileNumber() {
        pageObjectInitialization.loginPageAndroidActions.cancelGooglePopUp();
        pageObjectInitialization.loginPageAndroidActions.enterMobileNumber();
    }

    @Then("enters the OTP")
    public void entersTheOTP() throws InterruptedException {
        pageObjectInitialization.loginPageAndroidActions.entersOtp();
    }


    @And("Verify user has landed in user Details section and then fill in Details")
    public void verifyUserHasLandedInUserDetailsSectionAndThenFillInDetails(DataTable table) {
        List<Map<String, String>> tableDate = table.asMaps(String.class,String.class);
        pageObjectInitialization.loginPageAndroidActions.userDetailsPageHeaderVerification();
        pageObjectInitialization.loginPageAndroidActions.fillInUserDetails(tableDate.get(0));

    }
}
