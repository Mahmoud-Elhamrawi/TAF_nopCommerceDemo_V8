package TestCases;

import Pagess.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC06_emailFriendTest extends TestBase{

    SoftAssert softAssert=new SoftAssert();
    P02_LoginPage loginPage ;
    P05_searchPage searchPage ;
    P07_EmailFriendPage emailFriendPage ;
    P03_LogOutPage logOutPage ;
    HomePage homePage ;

    @Test
    public void inviteUrFriendViaEmail() throws InterruptedException {
        //login

        loginPage = new P02_LoginPage(driver);
        homePage = new HomePage(driver);
        homePage.clickOnLoginLink();
        loginPage.loginProcess("selenium113@auto.com" ,"1234567");
        //search
        searchPage =new P05_searchPage(driver);
        searchPage.searchFuncUsingSuggestListFristItem("app");
        softAssert.assertTrue(searchPage.auoSuggest().getText().contains("Apple MacBook Pro 13"));
        System.out.println(searchPage.auoSuggest().getText());
        //email
        emailFriendPage = new P07_EmailFriendPage(driver);
        emailFriendPage.goToEmailFri();
        softAssert.assertTrue(emailFriendPage.asser11().getText().contains("Email a friend"));

        emailFriendPage.fillData("test@teml.net","for testing ");
        softAssert.assertTrue(emailFriendPage.assrt22().getText().contains("message has been sent"));
        //logout
        logOutPage = new P03_LogOutPage(driver);
        logOutPage.logOut();
        softAssert.assertEquals(driver.getCurrentUrl() , "https://demo.nopcommerce.com/");
        System.out.println(driver.getCurrentUrl());



    }



}
