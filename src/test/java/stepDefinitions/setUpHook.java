package stepDefinitions;


import driver.WebBrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageactions.PageObjectInitialization;
import utilities.PropertyReader;
import utilities.PropertyUtil;


public class setUpHook extends WebBrowserFactory {
    private WebBrowserFactory webBrowserFactory;
    public static ThreadLocal<Scenario> scenario = new ThreadLocal<>();

    public setUpHook(WebBrowserFactory webBrowserFactory) {
        this.webBrowserFactory = webBrowserFactory;
    }

    static {
        String env = PropertyReader.getProperties("mavenProperties.properties").getProperty("Env");
        PropertyUtil.loadProperties(env);
    }

    @Before
    public void Initiation(Scenario sc) {
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
