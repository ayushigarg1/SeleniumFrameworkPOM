package base;

import com.aventstack.extentreports.ExtentReports;
import extentReporterListener.ExtentReporterNG;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import utils.TestUtil;
import utils.WebEventListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public  static EventFiringWebDriver e_driver;
    public  static WebEventListener eventListener;

    public TestBase() {

        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("/Users/viushi/Projects/Selenium Project/SeleniumTest/src/main/java/config/properties");
            prop.load(ip);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/viushi/Projects/Selenium Project/SeleniumTest/src/main/resources/chromedriver-mac-x64/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
            driver.get(prop.getProperty("url"));
        } else {
            System.out.println("Invalid Browser");
        }
        e_driver = new EventFiringWebDriver( driver);
        // Now create object of EventListerHandler to register it with EventFiringWebDriver
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;

    }
    public static void extentReport(ExtentReports extentReports, String testcaseName)
    {
        ExtentReporterNG.createTest(extentReports, testcaseName);
    }



}

