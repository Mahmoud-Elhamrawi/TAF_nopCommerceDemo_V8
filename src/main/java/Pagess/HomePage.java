package Pagess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage  extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
    }


    private By registerLink= By.cssSelector("a[class=\"ico-register\"]");
    private  By loginLink = By.cssSelector("a[class=\"ico-login\"]");

    public void clickOnRegisterLink()
    {
        clickEle(driver.findElement(registerLink));
    }
    public void  clickOnLoginLink()
    {
        clickEle(driver.findElement(loginLink));
    }

    private By assertContentReg =By.cssSelector("div[class=\"page-title\"] h1");
    private By assertContentLog =By.cssSelector("div[class=\"page-title\"] h1");
    public WebElement assetContentRegister()
    {
        return driver.findElement(assertContentReg);
    }
    public WebElement assetContentLogin()
    {
        return driver.findElement(assertContentLog);
    }





}
