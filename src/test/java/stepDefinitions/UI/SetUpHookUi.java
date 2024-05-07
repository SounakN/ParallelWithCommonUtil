package stepDefinitions.UI;


import driver.WebBrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import PageActions.UI.PageObjectInitialization;
import utilities.PropertyReader;
import utilities.PropertyUtil;

import java.io.File;

import static driver.BasicConstants.*;

@Slf4j
public class SetUpHookUi extends WebBrowserFactory {
    private WebBrowserFactory webBrowserFactory;
    public static ThreadLocal<Scenario> scenario = new ThreadLocal<>();

    public SetUpHookUi(WebBrowserFactory webBrowserFactory) {
        this.webBrowserFactory = webBrowserFactory;
    }

/*    static {

    }*/

    @Before(value="@Web")
    @SneakyThrows
    public void Initiation(Scenario sc) {
        String env = PropertyReader.getProperties(DATA_CONFIG + File.separator + MAVEN_PROPERTIES_FILE).getProperty("Env");
        log.info("Loading data for the environment :: " + env);
        PropertyUtil.loadProperties(env);
      /*  HashMap<Integer, ArrayList<String>> vv = readExcelIntoHashMap(EXCEL_FOLDER_NAME + File.separator + "Book1.xlsx", "Sheet1");
        System.out.println(vv);
        Reader fr = convertFileIntoBufferedReader("TestData\\Test\\dd.txt");
        int hh;
        while ((hh = fr.read()) != -1) {
            char cc = (char) hh;
            System.out.println(cc);
        }
        String ff = convertFileToJsonString("TestData/check.json");
        System.out.println(ff);*/
      //  System.out.println(sc.getName() + " is being running at :: " + Thread.currentThread().getId() + ":" + PropertyUtil.getProperty("maven"));
        PageObjectInitialization.initializeObjects(webBrowserFactory);
        setBrowserType(PropertyUtil.getProperty("Driver"));
        scenario.set(sc);

    }


    @After(value="@Web")
    public void TearDown(Scenario sc) throws Exception {
        quit();
    }
}
