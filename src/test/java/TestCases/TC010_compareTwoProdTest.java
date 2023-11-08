package TestCases;

import Pagess.P011_comparePage;
import Pagess.P05_searchPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TC010_compareTwoProdTest extends TestBase{

    P05_searchPage searchPage ;
    SoftAssert softAssert = new SoftAssert();

    P011_comparePage comparePage ;




    @Test(priority = 1)
    public void search()
    {
        //search
        searchPage =new P05_searchPage(driver);
        searchPage.searchFuncUsingSuggestListFristItem("app");
        softAssert.assertTrue(searchPage.auoSuggest().getText().contains("Apple MacBook Pro 13"));
        System.out.println(searchPage.auoSuggest().getText());
        comparePage = new P011_comparePage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,400)");
        comparePage.clickBtnCompare();

        //wait
        WebDriverWait wait =new WebDriverWait(driver , Duration.ofSeconds(35));
        wait.until(ExpectedConditions.invisibilityOf((comparePage.notification())));

        //search again
       searchPage.searchFuncUsingSuggestListSecondItem("app");
        softAssert.assertTrue(searchPage.auoSuggest().getText().contains("Apple iCam"));
        System.out.println(searchPage.auoSuggest().getText());
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("scrollBy(0,400)");
        comparePage.clickBtnCompare();

        //wait
        WebDriverWait wait1 =new WebDriverWait(driver , Duration.ofSeconds(35));
        wait1.until(ExpectedConditions.invisibilityOf((comparePage.notification())));

        softAssert.assertAll();
    }


    @Test(priority = 2)
    public void goToCompareList()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,2550)");
        comparePage.goToCompareList();
        js.executeScript("scrollBy(0,500)");
        softAssert.assertTrue(driver.getCurrentUrl().contains("/compareproducts"));
        WebDriverWait wait1 =new WebDriverWait(driver , Duration.ofSeconds(40));
        wait1.until(ExpectedConditions.visibilityOf((comparePage.visibleBox())));

        softAssert.assertEquals(comparePage.assert11().getText() , "Apple iCam");
        softAssert.assertEquals(comparePage.assert22().getText() , "Apple MacBook Pro 13-inch");






        softAssert.assertAll();
    }






}
