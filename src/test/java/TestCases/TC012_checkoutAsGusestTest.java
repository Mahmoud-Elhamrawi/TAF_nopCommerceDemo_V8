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


    }
    @Test(priority = 3 , dependsOnMethods = "addToCrt")
    public void checkOutOrder()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,600)");

        checkoutAsGuestPage = new P013_checkoutAsGuestPage(driver);

        WebDriverWait wait =  new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(checkoutAsGuestPage.footer()));

        checkoutAsGuestPage.agreeCh1();
        checkoutAsGuestPage.agreeCh2();
        softAssert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/login/checkoutasguest?returnUrl=%2Fcart"));

        checkoutAsGuestPage.guestCheckBtnele();
        softAssert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/onepagecheckout#opc-billing"));

        checkoutAsGuestPage.fillBillingAddress("mahmoud","ali","mah@gmail.com","cairo","naisr city","25252","01278385814");

        checkoutAsGuestPage.methodShip();
        softAssert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/onepagecheckout#opc-payment_method"));

        checkoutAsGuestPage.methodPayment();

        softAssert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/onepagecheckout#opc-payment_info"));

        checkoutAsGuestPage.infoPayment();
        softAssert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/onepagecheckout#opc-confirm_order"));


        softAssert.assertTrue(checkoutAsGuestPage.assretNameShipping().getText().contains("mahmoud"));

        checkoutAsGuestPage.confirm();
        softAssert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/checkout/completed"));

        softAssert.assertTrue(checkoutAsGuestPage.assertSucess1().getText().contains("successfully processed"));

    checkoutAsGuestPage.compelete();
    softAssert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/"));




    }







}
