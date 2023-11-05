package Pagess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class P05_searchPage extends PageBase{
    public P05_searchPage(WebDriver driver) {
        super(driver);
    }
    private By searchInp = By.id("small-searchterms");

    private  By btnSearch = By.cssSelector("button[class=\"button-1 search-box-button\"]");
    private By suggestList = By.cssSelector("li[class=\"ui-menu-item\"]");


    private By assertOnSearchFromList = By.cssSelector("div[class=\"product-name\"] h1");

    private  By assertOnSearchFromBtn = By.cssSelector("h2[class=\"product-title\"] a");


   private  By waitUl= By.cssSelector("ul[id=\"ui-id-1\"]");

    public void searchFuncUsingSuggestListFristItem(String value)  {
        enterTxt(driver.findElement(searchInp),value);
        //Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(waitUl)));


        List<WebElement> lis = driver.findElements(suggestList);
        System.out.println(lis);
        clickEle(lis.get(0));
    }

    public void searchFuncUsingSuggestListSecondItem(String value)  {
        enterTxt(driver.findElement(searchInp),value);
        //Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(waitUl)));


        List<WebElement> lis = driver.findElements(suggestList);
        System.out.println(lis);
        clickEle(lis.get(1));
    }







    public void searchFuncUsingBtn(String value) {
        enterTxt(driver.findElement(searchInp),value);
        clickEle(driver.findElement(btnSearch));

    }

    public WebElement auoSuggest()
    {
        return driver.findElement(assertOnSearchFromList);
    }


    public WebElement searchBtn()
    {
        return driver.findElement(assertOnSearchFromBtn);
    }












}
