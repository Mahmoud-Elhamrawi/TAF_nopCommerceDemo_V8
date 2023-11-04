package TestCases;

import Pagess.P05_searchPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC03_SearchFromList extends TestBase{

    P05_searchPage searchPage ;
SoftAssert softAssert = new SoftAssert();

    @Test
    public void searchFromList() throws InterruptedException {

        searchPage =new P05_searchPage(driver);

        searchPage.searchFuncUsingSuggestList("app");
        softAssert.assertTrue(searchPage.auoSuggest().getText().contains("Apple MacBook Pro 13"));
        System.out.println(searchPage.auoSuggest().getText());

        softAssert.assertAll();

    }






}
