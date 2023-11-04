package Pagess;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {
    public WebDriver driver ;

    public PageBase(WebDriver driver)
    {
        this.driver =driver ;
    }


    public void clickEle(WebElement ele)
    {
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(ele));
        ele.click();

    }

    public void enterTxt(WebElement ele , String txt)
    {
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(ele));
        ele.sendKeys(txt);
    }








}
