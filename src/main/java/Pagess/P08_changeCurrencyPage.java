package Pagess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P08_changeCurrencyPage extends PageBase{
    public P08_changeCurrencyPage(WebDriver driver) {
        super(driver);
    }

    private By customerCurrency = By.id("customerCurrency");

    private  By eleWait =By.cssSelector("div[class=\"item-box\"]:nth-child(2)");
    private By assertCurr = By.xpath("//span[@class=\"price actual-price\"  and  text()=\"€1548.00\"]");



    public WebElement list()
    {
        return driver.findElement(customerCurrency) ;
    }

    public WebElement eleW()
    {
        return driver.findElement(eleWait) ;
    }
    public WebElement assert11()
    {
        return driver.findElement(assertCurr) ;
    }




}
