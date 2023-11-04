package Pagess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P06_ContactUsPage extends PageBase{
    public P06_ContactUsPage(WebDriver driver) {
        super(driver);
    }


    private By contactUsLink =By.cssSelector("a[href=\"/contactus\"]");
    private  By FullNameInp = By.id("FullName") ;
    private By EmailInp = By.id("Email");
    private  By Enquiry = By.id("Enquiry");
    private By btnSend = By.name("send-email");
    private By assert1 =By.cssSelector("div[class=\"result\"]");


    public void contact()
    {
        clickEle(driver.findElement(contactUsLink));
    }

    public void fillDataOfContact(String name ,String email , String msg)
    {
        enterTxt(driver.findElement(FullNameInp),name );
        enterTxt(driver.findElement(EmailInp), email);
        enterTxt(driver.findElement(Enquiry),msg );
        clickEle(driver.findElement(btnSend));
    }


    public WebElement assert11()
    {
        return driver.findElement(assert1);
    }


}
