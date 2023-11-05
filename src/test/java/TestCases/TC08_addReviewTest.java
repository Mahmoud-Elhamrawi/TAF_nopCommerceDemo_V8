package TestCases;

import Pagess.HomePage;
import Pagess.P02_LoginPage;
import Pagess.P05_searchPage;
import Pagess.P09_addReviewPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC08_addReviewTest extends TestBase{

    P02_LoginPage loginPage ;
    HomePage homePage ;
    P05_searchPage searchPage ;

    P09_addReviewPage addReviewPage ;
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void addReview() throws InterruptedException {
        //login
        homePage = new HomePage(driver);
        homePage.clickOnLoginLink();
        loginPage = new P02_LoginPage(driver);
        loginPage.loginProcess("mash@teml.net" ,"123456");
        //search from list
        searchPage =new P05_searchPage(driver);
        searchPage.searchFuncUsingSuggestListFristItem("app");
        softAssert.assertTrue(searchPage.auoSuggest().getText().contains("Apple MacBook Pro 13"));
        System.out.println(searchPage.auoSuggest().getText());
        //addReview
        addReviewPage = new P09_addReviewPage(driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,500)");
        Thread.sleep(1000);

        addReviewPage.reviewLink();

        softAssert.assertTrue(addReviewPage.assert11().getText().contains("Write your own review"));

        System.out.println(addReviewPage.assert11().getText());

        addReviewPage.fillReview("type","error in batery");

        softAssert.assertTrue(addReviewPage.assrt22().getText().contains("type"));
        System.out.println(addReviewPage.assrt22().getText());




    }






}
