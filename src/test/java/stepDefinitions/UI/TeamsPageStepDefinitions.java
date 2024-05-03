package stepDefinitions.UI;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import PageActions.UI.PageObjectInitialization;

import java.util.List;
import java.util.Map;

public class TeamsPageStepDefinitions {

    private PageObjectInitialization pageObjectInitialization = null;

    public TeamsPageStepDefinitions(PageObjectInitialization pageObjectInitialization) {
        this.pageObjectInitialization = pageObjectInitialization;
    }

    @And("user verifies the details of the Users")
    public void userVerifiesTheDetailsOfTheUsers(DataTable table) {
        List<Map<String, String>> tableMap = table.asMaps(String.class, String.class);
        tableMap.forEach(val -> {
            pageObjectInitialization.teamsPageActions.assertUserDataFromSettings(val);
        });
    }
}
