package TestCases;

import Pagess.P06_ContactUsPage;
import UserData.jsonDataReader;
import com.github.hemanthsridhar.CSVUtils;
import com.github.hemanthsridhar.lib.ExtUtils;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class TC05_ContactUsTest extends TestBase{

    P06_ContactUsPage contactUsPage ;
    SoftAssert softAssert =new SoftAssert();
    jsonDataReader jsReader ;




    @Test
    public void contactPage() throws InterruptedException, IOException, ParseException {
        jsReader = new jsonDataReader();
        jsReader.jsonReader();


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        Thread.sleep(1000);

      contactUsPage = new P06_ContactUsPage(driver);
      contactUsPage.contact();

      softAssert.assertTrue(driver.getCurrentUrl().contains("contactus"));

      contactUsPage.fillDataOfContact(jsReader.name,jsReader.email,jsReader.msg);

      softAssert.assertTrue(contactUsPage.assert11().getText().contains("Your enquiry has been successfully"));

        softAssert.assertAll();
    }
}
