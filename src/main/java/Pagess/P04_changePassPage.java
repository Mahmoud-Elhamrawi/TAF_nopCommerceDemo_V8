package Pagess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P04_changePassPage extends PageBase{
    public P04_changePassPage(WebDriver driver) {
        super(driver);
    }

    private By myAccountLink =By.cssSelector("a[class=\"ico-account\"]");
    private By assert1 = By.cssSelector("div[class=\"page-title\"]  h1");
    private  By changePassLink =By.cssSelector("a[href=\"/customer/changepassword\"]");
    private By assert2 = By.cssSelector("div[class=\"page-title\"] h1");

    private  By oldPassInp = By.id("OldPassword");
    private  By newPassInp = By.id("NewPassword");
    private  By confirmPassInp = By.id("ConfirmNewPassword");
    private By changeBtn = By.cssSelector("button[class=\"button-1 change-password-button\"]");

    private By assert3= By.cssSelector("div[class=\"bar-notification success\"] p");

    private By assert4 =By.cssSelector("div[class=\"bar-notification success\"]");
    private  By closeNotif = By.cssSelector("span[class=\"close\"]");




    public void goToMyAccount()
    {
        clickEle(driver.findElement(myAccountLink));
    }
    public void goToChangePass()
    {
        clickEle(driver.findElement(changePassLink));
    }

    public void changePass(String p1 , String p2)
    {
        enterTxt(driver.findElement(oldPassInp),p1);
        enterTxt(driver.findElement(newPassInp),p2);
        enterTxt(driver.findElement(confirmPassInp),p2);
        clickEle(driver.findElement(changeBtn));


    }



    public WebElement assert11()
    {
        return driver.findElement(assert1);

    }


    public WebElement assert12()
    {
        return driver.findElement(assert2);

    }

    public WebElement assert13()
    {
        return driver.findElement(assert3);

    }

    public WebElement assert14()
    {
        return driver.findElement(assert4);

    }


    public void closeNot()
    {
        clickEle(driver.findElement(closeNotif));
    }



}
