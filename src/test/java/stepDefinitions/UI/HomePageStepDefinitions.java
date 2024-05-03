package stepDefinitions.UI;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import PageActions.UI.PageObjectInitialization;

public class HomePageStepDefinitions {
    private PageObjectInitialization pageObjectInitialization = null;

    public HomePageStepDefinitions(PageObjectInitialization pageObjectInitialization) {
        this.pageObjectInitialization = pageObjectInitialization;
    }

    @And("verifies that he has landed on Home Page")
    public void verifiesThatHeHasLandedOnHomePage() {
        pageObjectInitialization.homePageActions.verifyPage();
    }

    @Then("User clicks on the Section {string} and Verifies the presence of Header {string}")
    public void userClicksOnTheSectionAndVerifiesThePresenceOfHeader(String sectionValue, String headerValue) {
        pageObjectInitialization.homePageActions.clicksOnSectionWithDropdown(sectionValue);
        pageObjectInitialization.homePageActions.checkHeaderPresence(headerValue);
    }


    @Then("User clicks on the Section Team and then goes to {string}")
    public void userClicksOnTheSectionTeamAndThenGoesTo(String teamsMenu) {
        pageObjectInitialization.homePageActions.chooseAndClickOnTeamsMenu(teamsMenu, pageObjectInitialization.commonPageActions.clickOnTeams());
    }

}
