package TestCases;

import Pagess.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TC13_checkoutAsRegistered extends TestBase{
    P03_LogOutPage logOutPage ;
    SoftAssert softAssert = new SoftAssert();
    HomePage homePage ;
    P01_RegisterPage registerPage ;
    P05_searchPage searchPage ;
    P012_addToCartPAge addToCartPAge ;

    @Test(priority = 1)
    public void register()
    {
        homePage = new HomePage(driver);
        homePage.clickOnRegisterLink();

        registerPage = new P01_RegisterPage(driver);
        registerPage.registerProcess("moaaz","mahmoud","moaz@test25.com","123456","123456");

        softAssert.assertTrue(registerPage.assertContent1().getText().contains("Your registration completed"));
        System.out.println(registerPage.assertContent1().getText());
        softAssert.assertTrue(registerPage.assertContent2().getText().contains("CONTINUE"));
        System.out.println(registerPage.assertContent2().getText());
    }


    @Test(priority = 2)
    public void search()
    {
        searchPage =new P05_searchPage(driver);

        searchPage.searchFuncUsingSuggestListFristItem("app");
        softAssert.assertTrue(searchPage.auoSuggest().getText().contains("Apple MacBook Pro 13"));
        System.out.println(searchPage.auoSuggest().getText());

        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void addToCart()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,500)");

        addToCartPAge  = new P012_addToCartPAge(driver);
        addToCartPAge.btnCart();
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(addToCartPAge.notification()));



        addToCartPAge.goToCartList();

        softAssert.assertTrue(driver.getCurrentUrl().contains("com/cart"));
        softAssert.assertTrue(addToCartPAge.assertTitle().getText().contains("Shopping cart"));
        softAssert.assertTrue(addToCartPAge.assertContent().getText().contains("Apple MacBook Pro 13-inch"));

        wait.until(ExpectedConditions.visibilityOf(addToCartPAge.cartBodyPage()));

        js.executeScript("scrollBy(0,600)");

        WebDriverWait wait2 =  new WebDriverWait(driver , Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.visibilityOf(addToCartPAge.footer()));

        addToCartPAge.agreeCh1();
        addToCartPAge.agreeCh2();

        softAssert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/login/checkoutasguest?returnUrl=%2Fcart"));

        System.out.println(driver.getCurrentUrl());







    }













}
