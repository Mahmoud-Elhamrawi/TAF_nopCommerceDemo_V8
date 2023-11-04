package TestCases;

import Pagess.P06_ContactUsPage;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC05_ContactUsTest extends TestBase{

    P06_ContactUsPage contactUsPage ;
    SoftAssert softAssert =new SoftAssert();


    @Test
    public void contactPage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,3000)");
        Thread.sleep(1000);

      contactUsPage = new P06_ContactUsPage(driver);
      contactUsPage.contact();

      softAssert.assertTrue(driver.getCurrentUrl().contains("contactus"));

      contactUsPage.fillDataOfContact("moaz","test@teml.net","web testing ui");

      softAssert.assertTrue(contactUsPage.assert11().getText().contains("Your enquiry has been successfully"));

        softAssert.assertAll();
    }
}
