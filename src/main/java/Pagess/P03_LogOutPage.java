package Pagess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_LogOutPage extends PageBase{
    public P03_LogOutPage(WebDriver driver) {
        super(driver);
    }

    private By logoutLink = By.cssSelector("a[class=\"ico-logout\"]");


    public void logOut()
    {
        clickEle(driver.findElement(logoutLink));
    }


}
