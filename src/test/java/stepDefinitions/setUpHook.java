package stepDefinitions;


import driver.WebBrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import pageactions.PageObjectInitialization;
import utilities.PropertyReader;
import utilities.PropertyUtil;

import java.io.File;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;

import static driver.BasicConstants.*;
import static utilities.BasicExcelReader.readExcelIntoHashMap;
import static utilities.ReaderModels.convertFileIntoBufferedReader;
import static utilities.ReaderModels.convertFileToJsonString;

@Slf4j
public class setUpHook extends WebBrowserFactory {
    private WebBrowserFactory webBrowserFactory;
    public static ThreadLocal<Scenario> scenario = new ThreadLocal<>();

    public setUpHook(WebBrowserFactory webBrowserFactory) {
        this.webBrowserFactory = webBrowserFactory;
    }

    static {
        String env = PropertyReader.getProperties(DATA_CONFIG + File.separator + MAVEN_PROPERTIES_FILE).getProperty("Env");
        log.info("Loading data for the environment :: " + env);
        PropertyUtil.loadProperties(env);
    }

    @Before
    @SneakyThrows
    public void Initiation(Scenario sc) {
        HashMap<Integer, ArrayList<String>> vv = readExcelIntoHashMap(EXCEL_FOLDER_NAME + File.separator + "Book1.xlsx", "Sheet1");
        System.out.println(vv);
        Reader fr = convertFileIntoBufferedReader("TestData\\Test\\dd.txt");
        int hh;
        while ((hh = fr.read()) != -1) {
            char cc = (char) hh;
            System.out.println(cc);
        }
        String ff = convertFileToJsonString("TestData/check.json");
        System.out.println(ff);
        System.out.println(sc.getName() + " is being running at :: " + Thread.currentThread().getId() + ":" + PropertyUtil.getProperty("maven"));
        PageObjectInitialization.initializeObjects(webBrowserFactory);
        setBrowserType(PropertyUtil.getProperty("Driver"));
        scenario.set(sc);

    }


    @After
    public void TearDown(Scenario sc) throws Exception {
        quit();
    }
}
