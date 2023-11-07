package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import  Helper.Helper;

public class TestBase {

    protected WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    public void openBrowser(@Optional("edge") String browserName) {
        if (browserName.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
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