package TestCases;

import Pagess.HomePage;
import Pagess.P01_RegisterPage;
import Pagess.P02_LoginPage;
import Pagess.P03_LogOutPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC01_AuthenticationTest extends TestBase{

    HomePage homePage ;
    P01_RegisterPage registerPage ;

    P02_LoginPage loginPage ;
    P03_LogOutPage logOutPage ;
    SoftAssert softAssert = new SoftAssert();

    @DataProvider(name="userDataRegister")
    public static Object[][] provider()
    {
        return new Object[][]
                {
                        {"auto1","selenium1","selenium113@auto.com","123456","123456"},
                        {"auto2","selenium2","selenium224@auto.com","123456","123456"},
                        {"auto3","selenium3","selenium335@auto.com","123456","123456"},
                        {"auto4","selenium4","selenium446@auto.com","123456","123456"}

                };
    }

    @Test(dataProvider = "userDataRegister")
    public void Auth(String fn , String ln ,String em ,String pass, String cpass)
    {
        //register
        homePage = new HomePage(driver);
        homePage.clickOnRegisterLink();

        registerPage = new P01_RegisterPage(driver);

        registerPage.registerProcess(fn,ln,em,pass,cpass);

        softAssert.assertTrue(registerPage.assertContent1().getText().contains("Your registration completed"));
        System.out.println(registerPage.assertContent1().getText());
        softAssert.assertTrue(registerPage.assertContent2().getText().contains("CONTINUE"));
        System.out.println(registerPage.assertContent2().getText());

       //login
        loginPage = new P02_LoginPage(driver);
        homePage.clickOnLoginLink();

        loginPage.loginProcess(em ,pass);

       //logout

        logOutPage = new P03_LogOutPage(driver);
        logOutPage.logOut();

        softAssert.assertEquals(driver.getCurrentUrl() , "https://demo.nopcommerce.com/");
        System.out.println(driver.getCurrentUrl());



        softAssert.assertAll();
    }




}
