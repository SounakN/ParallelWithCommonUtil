package stepDefinitions;


import driver.WebBrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageactions.PageObjectInitialization;
import utilities.EnvUtil;


public class setUpHook extends WebBrowserFactory {
    private WebBrowserFactory webBrowserFactory;
    public static ThreadLocal<Scenario> scenario = new ThreadLocal<>();

    public setUpHook(WebBrowserFactory webBrowserFactory) {
        this.webBrowserFactory = webBrowserFactory;
    }

    @Before
    public void Initiation(Scenario sc) throws Exception {
        EnvUtil.loadProperties("QA");
        System.out.println(sc.getName() + " is being running at :: " + Thread.currentThread().getId() + ":" + EnvUtil.getProperty("maven"));
        PageObjectInitialization.initializeObjects(webBrowserFactory);
        setBrowserType(EnvUtil.getProperty("Driver"));
        scenario.set(sc);
    }


    @After
    public void TearDown(Scenario sc) throws Exception {
        quit();
    }
}
