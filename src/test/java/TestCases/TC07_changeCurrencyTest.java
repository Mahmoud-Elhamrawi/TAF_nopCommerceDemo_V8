package TestCases;

import Pagess.P08_changeCurrencyPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;


public class TC07_changeCurrencyTest extends TestBase{

     P08_changeCurrencyPage changeCurrencyPage ;
     SoftAssert softAssert =  new SoftAssert();



    @Test
    public void changeCurrency()
    {
        changeCurrencyPage =new P08_changeCurrencyPage(driver);

        Select sel = new Select(changeCurrencyPage.list());
        softAssert.assertTrue(sel.getFirstSelectedOption().getText().contains("US Dollar"));

        sel.selectByValue("https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,1200)");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(changeCurrencyPage.eleW()));

        softAssert.assertTrue(changeCurrencyPage.assert11().getText().contains("€"));

    }




}
