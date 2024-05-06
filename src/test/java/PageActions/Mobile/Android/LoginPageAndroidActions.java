package PageActions.Mobile.Android;

import driver.MobileFactory;
import io.appium.java_client.AppiumDriver;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepDefinitions.Mobile.Android.SetUpHookMobileAndroid;
import utilities.ActionMethods;
import utilities.PropertyUtil;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class LoginPageAndroidActions {
    //------------------------Locators----------------------------
    private  final String cancelGooglePopUpLoc = "//android.widget.ImageView[@content-desc='Cancel']";
  private final String loginButtonLoc ="//android.widget.TextView[@text='LOGIN']";
  private final String mobileNumberLoc ="//android.widget.EditText[contains(@resource-id,'mobile_no')]";
  private final String getOtpLoc ="//android.widget.TextView[@text='GET OTP']";
  private final String otpLoc ="//android.widget.RelativeLayout[contains(@resource-id,'otpfield')]//android.widget.TextView";
  private final String firstNameInputLoc ="//android.widget.EditText[contains(@resource-id,'first_name')]";
  private final String lastnameInputLoc ="//android.widget.EditText[contains(@resource-id,'last_name')]";
  private final String emailInputLoc ="//android.widget.EditText[contains(@resource-id,'email')]";
  private final String userDetailsConfirmLoc ="//android.widget.TextView[@text='CONFIRM']";
    private final String userDetailsHeaderLoc ="//android.widget.TextView[contains(@resource-id,'LetStart')]";
  private final String allowAccessLoc ="//android.widget.TextView[@text='ALLOW ACCESS']";
  private final String grantPermissionWidgetLoc ="//android.widget.LinearLayout[contains(@resource-id,'grant_dialog')]";
  private final String allowPermissionLoc ="//android.widget.Button[@text='Allow']";
  private final String denyPermissionLoc ="//android.widget.Button[@text='Deny']";
    //------------------------Locators----------------------------
    private AppiumDriver driver;
    private Properties prop;
    ActionMethods<AppiumDriver> actionMethods = null;

    public LoginPageAndroidActions(MobileFactory mobileFactory) {
        driver = mobileFactory.getDriverService();
        prop = PropertyUtil.getProperties();
        actionMethods = new ActionMethods<>();
    }

    public void cancelGooglePopUp(){
        WebElement googlePopUp = actionMethods.findElement(By.xpath(cancelGooglePopUpLoc),driver, Duration.ofSeconds(30),Duration.ofSeconds(5));
        assertThat(actionMethods.waitTillElementVisible(driver,googlePopUp)).isTrue();
        actionMethods.reporting().embedText(SetUpHookMobileAndroid.scenario.get(),"Found Google pop Up");
        actionMethods.click(driver, googlePopUp);
    }
    public void enterMobileNumber(String mobileNumber){
        WebElement mobileNumberElement = actionMethods.findElement(By.xpath(mobileNumberLoc),driver,Duration.ofSeconds(30),Duration.ofSeconds(5));
        assertThat(actionMethods.isClickable(driver,mobileNumberElement)).isTrue();
        actionMethods.type(driver,mobileNumberElement,mobileNumber);
        actionMethods.reporting().embedScreenshot(driver, SetUpHookMobileAndroid.scenario.get(),"Mobile number entered");
    }
    public void entersOtp() throws InterruptedException {
        WebElement getOtpElement = actionMethods.findElement(By.xpath(getOtpLoc),driver,Duration.ofSeconds(30),Duration.ofSeconds(5));
        assertThat(actionMethods.isClickable(driver,getOtpElement)).isTrue();
        actionMethods.click(driver,getOtpElement);

        List<WebElement> otpElements = actionMethods.findElements(By.xpath(otpLoc),driver,Duration.ofSeconds(30),Duration.ofSeconds(5));
        assertThat(otpElements.size()).isEqualTo(4);
        actionMethods.reporting().embedScreenshot(driver, SetUpHookMobileAndroid.scenario.get(),"OTP Page loaded");
        otpElements.stream().forEach(elem->{
            assertThat(actionMethods.isClickable(driver,elem)).isTrue();
            actionMethods.actionsCommands().moveToElement(driver,elem);
            actionMethods.actionsCommands().type(driver,"9");
        });
/*


        WebElement allowAccessElement = actionMethods.findElement(By.xpath(allowAccessLoc),driver,Duration.ofSeconds(30),Duration.ofSeconds(5));
        assertThat(actionMethods.isClickable(driver,allowAccessElement)).isTrue();
        actionMethods.click(driver,allowAccessElement);

        WebElement grantPermissionWidgetElement = actionMethods.findElement(By.xpath(grantPermissionWidgetLoc),driver,Duration.ofSeconds(30),Duration.ofSeconds(5));
        assertThat(actionMethods.waitTillElementVisible(driver,grantPermissionWidgetElement)).isTrue();

        WebElement allowPermissionElement = actionMethods.findElement(By.xpath(allowPermissionLoc),driver,Duration.ofSeconds(30),Duration.ofSeconds(5));
        actionMethods.click(driver,allowPermissionElement);*/

    }


    public void userDetailsPageHeaderVerification() {
        WebElement userDetailsHeaderElement = actionMethods.findElement(By.xpath(userDetailsHeaderLoc),driver,Duration.ofSeconds(30),Duration.ofSeconds(5));
        assertThat(userDetailsHeaderElement).isNotNull();
        actionMethods.reporting().embedText(SetUpHookMobileAndroid.scenario.get(),"Landed on User details page");
        assertThat(actionMethods.waitTillElementVisible(driver,userDetailsHeaderElement)).isTrue();
    }

    @SneakyThrows
    public void fillInUserDetails(Map<String, String> userdata){
        WebElement firstNameElement = actionMethods.findElement(By.xpath(firstNameInputLoc),driver,Duration.ofSeconds(30),Duration.ofSeconds(5));
        assertThat(actionMethods.waitTillElementVisible(driver,firstNameElement)).isTrue();
        actionMethods.type(driver,firstNameElement,userdata.get("FirstName"));

        WebElement lastNameElement = actionMethods.findElement(By.xpath(lastnameInputLoc),driver,Duration.ofSeconds(30),Duration.ofSeconds(5));
        assertThat(actionMethods.waitTillElementVisible(driver,lastNameElement)).isTrue();
        actionMethods.type(driver,lastNameElement,userdata.get("LastName"));

        WebElement emailInputElement = actionMethods.findElement(By.xpath(emailInputLoc),driver,Duration.ofSeconds(30),Duration.ofSeconds(5));
        assertThat(actionMethods.waitTillElementVisible(driver,emailInputElement)).isTrue();
        actionMethods.type(driver,emailInputElement,userdata.get("Email"));

        actionMethods.reporting().embedScreenshot(driver,SetUpHookMobileAndroid.scenario.get(),"Filled up user details");

        WebElement userDetailsConfirmElement = actionMethods.findElement(By.xpath(userDetailsConfirmLoc),driver,Duration.ofSeconds(30),Duration.ofSeconds(5));
        assertThat(userDetailsConfirmElement).isNotNull();
        actionMethods.reporting().embedText(SetUpHookMobileAndroid.scenario.get(),"Found confirm button");
        assertThat(actionMethods.waitTillElementVisible(driver,userDetailsConfirmElement)).isTrue();
        actionMethods.click(driver, userDetailsConfirmElement);

    }
}
