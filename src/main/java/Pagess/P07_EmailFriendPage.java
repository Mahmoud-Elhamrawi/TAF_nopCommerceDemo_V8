package Pagess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P07_EmailFriendPage extends PageBase{

    public P07_EmailFriendPage(WebDriver driver) {
        super(driver);
    }


    private By emailBtn = By.cssSelector("button[class=\"button-2 email-a-friend-button\"]");
    private  By asertTitle = By.cssSelector("div[class=\"page-title\"] h1");
    private By friendEmailInp = By.id("FriendEmail");
    private By eamilAddrInp = By.id("YourEmailAddress");
    private By msg = By.id("PersonalMessage");
    private By btnSend = By.name("send-email");

    private  By assertSend = By.cssSelector("div[class=\"result\"]");


    public  void goToEmailFri()
    {
        clickEle(driver.findElement(emailBtn));
    }

    public WebElement asser11()
    {
        return driver.findElement(asertTitle);
    }
    public void fillData(String emailFri  ,String mess)
    {
        enterTxt(driver.findElement(friendEmailInp),emailFri );
        //enterTxt(driver.findElement(eamilAddrInp),myEmail );
        enterTxt(driver.findElement(msg), mess);
        clickEle(driver.findElement(btnSend));
    }

    public WebElement assrt22()
    {
        return driver.findElement(assertSend);
    }





}
