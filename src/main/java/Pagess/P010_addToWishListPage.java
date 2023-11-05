package Pagess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P010_addToWishListPage extends PageBase {

    public P010_addToWishListPage(WebDriver driver){
        super(driver);
    }

   private By  wishListBtn = By.id("add-to-wishlist-button-4");
    private By wishListLink =By.cssSelector("a[class=\"ico-wishlist\"]");
   
    private  By close = By.cssSelector("div[id=\"bar-notification\"]");
    private By assrtSearchWord = By.cssSelector("td[class=\"product-picture\"] a[href=\"/apple-macbook-pro-13-inch\"]");
    private By removeBtn = By.className("remove-btn");
    private By noData = By.className("no-data");




    public void addToWishList()
    {
        clickEle(driver.findElement(wishListBtn));
    }


    public WebElement close1()
    {
        return driver.findElement(close);
    }


    public void goToWishList()
    {
        clickEle(driver.findElement(wishListLink));
    }

    public WebElement assert11()
    {
        return driver.findElement(assrtSearchWord);
    }


    public void removeItem()
    {
        clickEle(driver.findElement(removeBtn));
    }

    public WebElement assrt22()
    {
        return driver.findElement(noData);
    }













}
