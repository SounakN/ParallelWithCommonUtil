package stepDefinitions.Mobile;


import PageActions.Mobile.Android.PageObjectInitializationAndroid;
import PageActions.UI.PageObjectInitialization;
import driver.MobileFactory;
import driver.WebBrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import utilities.PropertyReader;
import utilities.PropertyUtil;

import java.io.File;

import static driver.BasicConstants.DATA_CONFIG;
import static driver.BasicConstants.MAVEN_PROPERTIES_FILE;

@Slf4j
public class setUpHook extends MobileFactory {
    private MobileFactory mobileFactory;
    public static ThreadLocal<Scenario> scenario = new ThreadLocal<>();

    public setUpHook(MobileFactory mobileFactory) {
        this.mobileFactory = mobileFactory;
    }

/*    static {

    }*/

    @Before
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
        PageObjectInitializationAndroid.initializeObjects(mobileFactory);
        setMobileType(PropertyUtil.getProperty("Driver_mobile"));
       /* scenario.set(sc);*/

    }


    @After
    public void TearDown(Scenario sc) throws Exception {
        quit();
    }
}
