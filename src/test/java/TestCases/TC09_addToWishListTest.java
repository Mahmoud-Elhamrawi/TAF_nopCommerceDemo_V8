package TestCases;

import Pagess.P010_addToWishListPage;
import Pagess.P05_searchPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;


public class TC09_addToWishListTest extends TestBase{
    P05_searchPage searchPage ;
    SoftAssert softAssert = new SoftAssert();

    P010_addToWishListPage addToWishListPage ;


    @Test(priority = 1)
    public void search()  {
        searchPage =new P05_searchPage(driver);
        searchPage.searchFuncUsingSuggestListFristItem("app");
        softAssert.assertTrue(searchPage.auoSuggest().getText().contains("Apple MacBook Pro 13"));
        System.out.println(searchPage.auoSuggest().getText());
        softAssert.assertAll();
    }


    @Test(priority = 2)
    public void addTOWish() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,500)");

        addToWishListPage =new P010_addToWishListPage(driver);
        addToWishListPage.addToWishList();

        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf((addToWishListPage.close1())));

        addToWishListPage.goToWishList();
        softAssert.assertTrue(driver.getCurrentUrl().contains("/wishlist"));
        System.out.println(driver.getCurrentUrl());
        softAssert.assertEquals("Apple MacBook Pro 13-inch" ,addToWishListPage.assert11().getText());







    }


    @Test(priority = 3 , dependsOnMethods = "addTOWish")
    public void removeWish()
    {
      addToWishListPage.removeItem();
      softAssert.assertTrue(addToWishListPage.assrt22().getText().contains("wishlist is empty"));
        System.out.println(addToWishListPage.assrt22().getText());



    }



}
