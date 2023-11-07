package Pagess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P012_addToCartPAge extends PageBase{
    public P012_addToCartPAge(WebDriver driver) {
        super(driver);
    }

    private By cartBtn = By.cssSelector("button[id=\"add-to-cart-button-4\"]");
    private  By notifyVisi = By.cssSelector("div[id=\"bar-notification\"]");

    private By cartBody = By.cssSelector("table[class=\"cart\"]");

    private By cartLink = By.cssSelector(" div[class=\"bar-notification success\"] a");
    private  By assrtTitle = By.cssSelector("div[class=\"page-title\"] h1");
    private  By assertTdContent = By.cssSelector("td[class=\"product\"] a");

    private By waitBody = By.cssSelector("div[class=\"page-body\"]");


    private  By updateBtn = By.cssSelector("button[id=\"updatecart\"]");

    private By ValUp = By.cssSelector("td[class=\"quantity\"] input");


    private By agreeCheck =  By.id("termsofservice");

    private By btnCheck = By.id("checkout");
    private  By footerAppear =By.cssSelector("div[class=\"cart-footer\"] div[class=\"totals\"]");


    public void agreeCh1()
    {
        clickEle(driver.findElement(agreeCheck));

    }

    public void agreeCh2()
    {
        clickEle(driver.findElement(btnCheck));
    }

    public WebElement footer()
    {
        return driver.findElement(footerAppear);
    }






    public void btnCart()
    {
        clickEle(driver.findElement(cartBtn));
    }

    public WebElement  notification()
    {
        return driver.findElement(notifyVisi);
    }
    public WebElement  cartBodyPage()
    {
        return driver.findElement(cartBody);
    }



    public void goToCartList()
    {
        clickEle(driver.findElement(cartLink));
    }
    public WebElement  assertTitle()
    {
        return driver.findElement(assrtTitle);
    }
    public WebElement  assertContent()
    {
        return driver.findElement(assertTdContent);
    }

    public WebElement waitBod()
    {
        return driver.findElement(waitBody);
    }
    public void btnUpdate()
    {
        clickEle(driver.findElement(updateBtn));
    }

    public WebElement qupdate()
    {
        return driver.findElement(ValUp);
    }














}
