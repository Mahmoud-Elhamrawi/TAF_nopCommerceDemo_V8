package TestCases;

import Pagess.P012_addToCartPAge;
import Pagess.P013_checkoutAsGuestPage;
import Pagess.P05_searchPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TC012_checkoutAsGusestTest extends  TestBase{

    P05_searchPage searchPage ;
    SoftAssert softAssert = new SoftAssert() ;
    P012_addToCartPAge addToCartPAge ;
    P013_checkoutAsGuestPage checkoutAsGuestPage ;


    @Test(priority = 1)
    public void search()
    {
        searchPage =new P05_searchPage(driver);
        searchPage.searchFuncUsingSuggestListFristItem("app");
        softAssert.assertTrue(searchPage.auoSuggest().getText().contains("Apple MacBook Pro 13"));
        System.out.println(searchPage.auoSuggest().getText());
        softAssert.assertAll();
    }
    @Test(priority = 2)
    public void addToCrt()
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
    @Test(priority = 3 , dependsOnMethods = "addToCrt")
    public void checkOutOrder() throws InterruptedException {

        checkoutAsGuestPage = new P013_checkoutAsGuestPage(driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,500)");

        checkoutAsGuestPage.guestCheckBtnele();
        softAssert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/onepagecheckout#opc-billing"));
        System.out.println(driver.getCurrentUrl());
        checkoutAsGuestPage.fillBillingAddress("mahmoud","ali","mah@gmail.com","cairo","naisr city","25252","01278385814");
        Thread.sleep(1000);
        System.out.println(driver.getCurrentUrl());
        checkoutAsGuestPage.methodShip();
        Thread.sleep(1000);
        softAssert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/onepagecheckout#opc-payment_method"));
        System.out.println(driver.getCurrentUrl());

        checkoutAsGuestPage.methodPayment();
        Thread.sleep(1000);
        softAssert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/onepagecheckout#opc-payment_info"));
        System.out.println(driver.getCurrentUrl());

        checkoutAsGuestPage.infoPayment();
        Thread.sleep(2000);
        softAssert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/onepagecheckout#opc-confirm_order"));
        System.out.println(driver.getCurrentUrl());
        softAssert.assertTrue(checkoutAsGuestPage.assretNameShipping().getText().contains("mahmoud"));


        js.executeScript("scrollBy(0,300)");
        checkoutAsGuestPage.confirmoorder();
        Thread.sleep(1500);
        softAssert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/checkout/completed"));
        System.out.println(driver.getCurrentUrl());
        softAssert.assertTrue(checkoutAsGuestPage.assertSucess1().getText().contains("successfully processed"));
        System.out.println(checkoutAsGuestPage.assertSucess1().getText());

        checkoutAsGuestPage.compeleteorder();
        Thread.sleep(1000);
        softAssert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/"));
        System.out.println(driver.getCurrentUrl());


        softAssert.assertAll();

    }







}
