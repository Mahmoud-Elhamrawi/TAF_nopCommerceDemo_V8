package TestCases;

import Pagess.P05_searchPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC04_searchFromBtn extends TestBase{
    P05_searchPage searchPage ;
    SoftAssert softAssert =new SoftAssert();

    @Test
    public void searchFromBtn() throws InterruptedException {
      searchPage = new P05_searchPage(driver);
      searchPage.searchFuncUsingBtn("Apple MacBook Pro 13-inch");
      Thread.sleep(1000);
      softAssert.assertEquals(searchPage.searchBtn().getText(),"Apple MacBook Pro 13-inch");
        System.out.println(searchPage.searchBtn().getText());



        softAssert.assertAll();
    }



}
