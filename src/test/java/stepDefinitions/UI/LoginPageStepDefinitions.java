package stepDefinitions.UI;

import io.cucumber.java.en.Then;
import lombok.SneakyThrows;
import PageActions.UI.PageObjectInitialization;

public class LoginPageStepDefinitions {

    private PageObjectInitialization pageObjectInitialization = null;

    public LoginPageStepDefinitions(PageObjectInitialization pageObjectInitialization) {
        this.pageObjectInitialization = pageObjectInitialization;
    }


    @SneakyThrows
    @Then("Logs in using the credentials")
    public void logsInUsingTheCredentials() {
        pageObjectInitialization.loginPageActions.enterInCredentials();
        pageObjectInitialization.loginPageActions.login();
    }

}
