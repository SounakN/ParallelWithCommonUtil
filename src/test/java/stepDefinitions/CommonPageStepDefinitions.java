package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.SneakyThrows;
import pageactions.PageObjectInitialization;

public class CommonPageStepDefinitions {

    private PageObjectInitialization pageObjectInitialization = null;

    public CommonPageStepDefinitions(PageObjectInitialization pageObjectInitialization) {
        this.pageObjectInitialization = pageObjectInitialization;
    }

    @SneakyThrows
    @Given("User hits the URl of mindAi")
    public void userHitsTheURlOfMindAi() {
        pageObjectInitialization.commonPageActions.goToUrl();
    }

    @Then("User closes the modal")
    public void userClosesTheModal() {
        pageObjectInitialization.commonPageActions.closesModal();
    }

    @Then("User logs out of the application")
    public void userLogsOutOfTheApplication() {
        pageObjectInitialization.commonPageActions.logsOut();
    }

}
