package TestCases;

import Pagess.HomePage;
import Pagess.P02_LoginPage;
import Pagess.P03_LogOutPage;
import Pagess.P04_changePassPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class TC02_changePassTest extends TestBase{

    SoftAssert softAssert= new SoftAssert();
    P02_LoginPage loginPage ;
    HomePage homePage ;
    P04_changePassPage changePassPage ;

    P03_LogOutPage logOutPage;

    @Test
    public void changePass()
    {
        homePage = new HomePage(driver);
        loginPage =new P02_LoginPage(driver);

        //login
        loginPage = new P02_LoginPage(driver);
        homePage.clickOnLoginLink();

        loginPage.loginProcess("selenium113@auto.com" ,"123456");

        //change password
         changePassPage = new P04_changePassPage(driver);
         changePassPage.goToMyAccount();
         softAssert.assertTrue(changePassPage.assert11().getText().contains("My account - Customer info"));

         changePassPage.goToChangePass();
         softAssert.assertTrue(changePassPage.assert12().getText().contains("My account - Change password"));

        changePassPage.changePass("123456","1234567");
        softAssert.assertTrue(changePassPage.assert13().getText().contains("Password was changed"));
        String BgColor = changePassPage.assert14().getCssValue("background-color");
        BgColor = Color.fromString(BgColor).asHex();
        softAssert.assertEquals(BgColor , "#4bb07a");

        changePassPage.closeNot();


        //logOut
        logOutPage = new P03_LogOutPage(driver);
        logOutPage.logOut();





         softAssert.assertAll();
    }
}
