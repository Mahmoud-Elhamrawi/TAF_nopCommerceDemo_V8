package Pagess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_LoginPage extends PageBase{
    public P02_LoginPage(WebDriver driver) {
        super(driver);
    }

    private By emailLogin = By.id("Email");
    private  By passLogin =By.id("Password");
    private By logBtn = By.cssSelector("button[class=\"button-1 login-button\"]");

    public void loginProcess(String em , String pass)
    {
        enterTxt(driver.findElement(emailLogin),em);
        enterTxt(driver.findElement(passLogin),pass );
        clickEle(driver.findElement(logBtn));
    }





}
