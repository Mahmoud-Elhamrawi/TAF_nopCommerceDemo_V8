package Pagess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class P013_checkoutAsGuestPage extends PageBase{
    public P013_checkoutAsGuestPage(WebDriver driver) {
        super(driver);
    }

    private By agreeCheck =  By.cssSelector("input[id=\"termsofservice\"]");
    private By btnCheck = By.xpath("//button[@id=\"checkout\"]");

    private By guestCheckBtn = By.xpath("//button[@id=\"checkout\"]");

    private  By footerAppear =By.cssSelector("div[class=\"cart-footer\"] div[class=\"totals\"]");



    private By firstNameInp = By.id("BillingNewAddress_FirstName");
    private  By lastNameInp = By.id("BillingNewAddress_LastName");
    private By emialInp = By.id("BillingNewAddress_Email");
    private  By selectCount = By.id("BillingNewAddress_CountryId");
    private By cityInp = By.id("BillingNewAddress_City");
    private  By addInp = By.id("BillingNewAddress_Address1");
    private By zipCodeInp = By.id("BillingNewAddress_ZipPostalCode");
    private By phonInp = By.id("BillingNewAddress_PhoneNumber");
    private  By contuionBtn = By.cssSelector("div[id=\"billing-buttons-container\"] button:nth-child(4)");


    private By shippingMethod =By.cssSelector("button[class=\"button-1 shipping-method-next-step-button\"]");

    private By paymentMethod = By.cssSelector("button[class=\"button-1 payment-method-next-step-button\"]");

    private By payInfo = By.cssSelector("button[class=\"button-1 payment-info-next-step-button\"]");

    private By assertShippingName = By.cssSelector("div[class=\"billing-info\"] ul[class=\"info-list\"]  li[class=\"name\"] ");

    private By confirmOrder = By.className("button-1 confirm-order-next-step-button");

    private  By assertSucess1 =By.cssSelector("div[class=\"title\"] strong");

    private  By compeletOrder =By.className("button-1 order-completed-continue-button");




    public WebElement footer()
    {
        return driver.findElement(footerAppear);
    }

    public void agreeCh1()
    {
        clickEle(driver.findElement(agreeCheck));

    }

    public void agreeCh2()
    {
        clickEle(driver.findElement(btnCheck));
    }

    public void guestCheckBtnele()
    {
        clickEle(driver.findElement(guestCheckBtn));
    }

    public void fillBillingAddress(String fn,String ls ,String em , String  city , String Add , String zip , String phone)
    {
        enterTxt(driver.findElement(firstNameInp),fn );
        enterTxt(driver.findElement(lastNameInp),ls );
        enterTxt(driver.findElement(emialInp),em );

        Select sel = new Select(driver.findElement(selectCount));
        sel.selectByValue("United States");
        enterTxt(driver.findElement(cityInp),city );
        enterTxt(driver.findElement(addInp),Add );
        enterTxt(driver.findElement(zipCodeInp),zip );
        enterTxt(driver.findElement(phonInp),phone );
        clickEle(driver.findElement(contuionBtn));


    }

    public  void methodShip()
    {
        clickEle(driver.findElement(shippingMethod));
    }


    public  void methodPayment()
    {
        clickEle(driver.findElement(paymentMethod));
    }

    public  void infoPayment()
    {
        clickEle(driver.findElement(payInfo));
    }


    public WebElement assretNameShipping()
    {
        return driver.findElement(assertShippingName);
    }

    public void confirm()
    {
        clickEle(driver.findElement(confirmOrder));
    }


    public WebElement assertSucess1()
    {
        return driver.findElement(assertSucess1);
    }

    public void compelete()
    {
        clickEle(driver.findElement(compeletOrder));
    }


}
