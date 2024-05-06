package stepDefinitions.Mobile.Android;


import PageActions.Mobile.Android.PageObjectInitializationAndroid;
import driver.MobileFactory;
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
public class SetUpHookMobileAndroid extends MobileFactory {
    private MobileFactory mobileFactory;
    public static ThreadLocal<Scenario> scenario = new ThreadLocal<>();
    public SetUpHookMobileAndroid(MobileFactory mobileFactory) {
        this.mobileFactory = mobileFactory;
    }


    @Before(value="@MobileAndroid")
    @SneakyThrows
    public void Initiation(Scenario sc) {
        String env = PropertyReader.getProperties(DATA_CONFIG + File.separator + MAVEN_PROPERTIES_FILE).getProperty("Env");
        log.info("Loading data for the environment :: {}", env);
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
        scenario.set(sc);

    }


    @After(value="@MobileAndroid")
    public void TearDown(Scenario sc) throws Exception {
        quit();
    }
}
