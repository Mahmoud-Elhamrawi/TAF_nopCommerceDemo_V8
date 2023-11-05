package TestCases;

import Pagess.P012_addToCartPAge;
import Pagess.P05_searchPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TC011_addToCartTest extends TestBase{
    P05_searchPage searchPage ;
    SoftAssert softAssert = new SoftAssert();
    P012_addToCartPAge addToCartPAge ;

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
    public void updateQantity() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(addToCartPAge.waitBod()));
        addToCartPAge.btnUpdate();
        Thread.sleep(1500);
        addToCartPAge.qupdate().clear();
        addToCartPAge.qupdate().sendKeys("3");
        addToCartPAge.btnUpdate();


        softAssert.assertTrue(addToCartPAge.qupdate().getText().contains("3"));
       // int q = Integer.parseInt(addToCartPAge.qupdate().getText());

    }



}
