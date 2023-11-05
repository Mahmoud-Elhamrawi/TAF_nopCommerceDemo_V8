package Pagess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P011_comparePage extends PageBase{
    public P011_comparePage(WebDriver driver) {
        super(driver);
    }

    private By addToComapreBtn = By.cssSelector("div[class=\"compare-products\"] button ");

    private  By notifyComapre = By.cssSelector("div[id=\"bar-notification\"]");

    private  By compareLink = By.cssSelector("a[href=\"/compareproducts\"]");

    private By listVisible = By.cssSelector("div[class=\"center-2\"]");
    private  By assert1 = By.xpath("//td //a[@href=\"/apple-icam\" and text()=\"Apple iCam\"]");
    private  By asset2= By.xpath("//td //a[@href=\"/apple-macbook-pro-13-inch\" and text()=\"Apple MacBook Pro 13-inch\"]");


    public void clickBtnCompare()
    {
        clickEle(driver.findElement(addToComapreBtn));
    }
    public WebElement notification()
    {
        return driver.findElement(notifyComapre);
    }

    public  void goToCompareList()
    {
        clickEle(driver.findElement(compareLink));
    }

    public WebElement visibleBox()
    {
        return driver.findElement(listVisible);
    }


    public WebElement assert11()
    {
        return driver.findElement(assert1);
    }

    public WebElement assert22()
    {
        return driver.findElement(asset2);
    }








}
