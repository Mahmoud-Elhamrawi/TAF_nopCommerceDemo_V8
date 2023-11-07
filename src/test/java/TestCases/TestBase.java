package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import  Helper.Helper;

public class TestBase {

    protected WebDriver driver;


    public static String downloadPath = System.getProperty("user.dir") + "\\Downloads";

    public static ChromeOptions chromeOption() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default.content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);
        options.setExperimentalOption("prefs", chromePrefs);
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

        return options;
    }



    @BeforeClass
    @Parameters({"browser"})
    public void openBrowser(@Optional("chrome") String browserName) {
        if (browserName.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver(chromeOption());
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }else if (browserName.equalsIgnoreCase("edge"))
        {
            driver = new EdgeDriver();
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        driver.get("https://demo.nopcommerce.com/");

    }


    @AfterClass
    public void cleanUp() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


    @AfterMethod
    public void screenShotFailure(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("fail...");
            System.out.println("taking screenshot.....");
            Helper.capturescreenshot(driver, result.getName());
        }


    }

}