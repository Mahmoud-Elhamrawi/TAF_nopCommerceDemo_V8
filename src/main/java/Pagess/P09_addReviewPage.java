package Pagess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class P09_addReviewPage extends PageBase{
    public P09_addReviewPage(WebDriver driver) {
        super(driver);
    }

  private By goToReviewLink = By.linkText("Add your review");

    private  By assrtTitle = By.cssSelector("div[class=\"page-title\"] h1");
    private  By  reviewTitleInp = By.id("AddProductReview_Title");
    private  By msg =By.id("AddProductReview_ReviewText");
    private  By radio =By.cssSelector("input[type=\"radio\"]");
    private  By btnAdd = By.name("add-review");

    private By assrtRev = By.cssSelector("div[class=\"product-review-list\"] div[class=\"product-review-item\"]:nth-child(2) div[class=\"review-item-head\"] div[class=\"review-title\"]");



    public void reviewLink()
    {
        clickEle(driver.findElement(goToReviewLink));
    }
    public WebElement assert11()
    {
        return driver.findElement(assrtTitle);
    }

    public void fillReview(String revTit , String mess)
    {
        enterTxt(driver.findElement(reviewTitleInp),revTit );
        enterTxt(driver.findElement(msg), mess);
        List<WebElement> lis = driver.findElements(radio) ;
        System.out.println(lis.size());
        clickEle(lis.get(3));
        clickEle(driver.findElement(btnAdd));
    }


    public WebElement assrt22()
    {
        return driver.findElement(assrtRev);
    }




}
