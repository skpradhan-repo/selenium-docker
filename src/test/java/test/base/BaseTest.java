package test.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setupDriver(ITestContext context) throws MalformedURLException {
        String host = "localhost";
        String browser = System.getProperty("BROWSER");
        DesiredCapabilities dc;

        if (browser != null && browser.equalsIgnoreCase("firefox")){
            dc = DesiredCapabilities.firefox();
        }else{
            dc = DesiredCapabilities.chrome();
        }

        if (System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }

//        host = "34.66.120.62";

        String completeUrl = "http://" + host + ":4444/wd/hub";

        String name = context.getName();

        System.out.println(name);

        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
    }

    @AfterTest
    public void quitDriver(){
        this.driver.close();
    }
}
