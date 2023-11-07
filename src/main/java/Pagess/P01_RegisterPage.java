package Pagess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P01_RegisterPage extends  PageBase{
    public P01_RegisterPage(WebDriver driver) {
        super(driver);
    }
    private By gender = By.id("gender-male");
    private By fName = By.id("FirstName");
    private By lName =By.id("LastName");
    private By selectDay =By.cssSelector("select[name=\"DateOfBirthDay\"]");
    private By selectMonth =By.cssSelector("name=\"DateOfBirthMonth\"");
    private By selectYear =By.cssSelector("name=\"DateOfBirthYear\"");
    private By emailInp = By.id("Email");
    private  By passInp =By.id("Password");
    private  By confirmPassInp =By.id("ConfirmPassword");
    private By regBtn =By.id("register-button");
    private By assert1 = By.cssSelector("div[class=\"page-body\"] div[class=\"result\"]");
    private By assert2 = By.cssSelector("div[class=\"buttons\"] a");


    public void registerProcess(String fn ,String ln ,String Em , String pass , String CPass)
    {
        clickEle(driver.findElement(gender));
        enterTxt(driver.findElement(fName) , fn);
        enterTxt(driver.findElement(lName),ln);
        enterTxt(driver.findElement(emailInp),Em);
        enterTxt(driver.findElement(passInp),pass);
        enterTxt(driver.findElement(confirmPassInp),CPass);
        clickEle(driver.findElement(regBtn));
    }

    //with use DDT//




    public WebElement assertContent1()
    {
        return driver.findElement(assert1);
    }
    public WebElement assertContent2()
    {
        return driver.findElement(assert2);
    }










}
