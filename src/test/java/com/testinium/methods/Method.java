package com.testinium.methods;


import com.testinium.driver.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;


public class Method {
    WebDriver mDriver;
    FluentWait<WebDriver> wait;

    JavascriptExecutor jsDriver;
    Logger mLogger= LogManager.getLogger(Method.class);

    public Method(){
        mDriver = BaseTest.mDriver;
        wait = new FluentWait<WebDriver>(mDriver);
        wait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
        jsDriver= (JavascriptExecutor) mDriver;
    }
    public void getPage(String url){
        mDriver.get(url);
    }
    public WebElement findElement(By by)
    {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public void click(By by){
        findElement(by).click();
    }


    public void waitBySeconds(long seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void sendKeys(By by, String text)
    {
        findElement(by).sendKeys(text);
    }
    public boolean isElementVisible(By by){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            mLogger.info("true");
            return true;
        }catch(Exception e){
            mLogger.info("false" + e.getMessage());
            return false;
        }

    }
    public void scrollWithAction(By by){
        Actions actions = new Actions(mDriver);
        actions.moveToElement(findElement(by)).build().perform();
    }

    public void scrollWithJs(By by){
        jsDriver.executeScript("arguments[0].scrollIntoView();",findElement(by));
    }

    public Select getSelect(By by){ // dropbox için

        return new Select(findElement(by));
    }

    public void selectByText(By by, String text){ // dropbox'taki textler
        getSelect(by).selectByVisibleText(text);
    }

    /*public String getAttribute(By by, String attributeName){ // elementin attribute'sini alır
        return findElement(by).getAttribute(attributeName);
    }     */

    /*
    public String getText(By by){ // bir elementin Text'ini alır

        return findElement(by).getText();
    }
    */

    /*public String getValue(By by){
        return jsDriver.executeScript("return arguments[0].value;",findElement(by)).toString();
    }
    */
    public String AddFavoritesXPath(int number){
        var st = String.format("(//div[@class='product-cr'][%s])/div[@class='grid_2 alpha omega relative']/div[@class='hover-menu']/a[@class='add-to-favorites']", number);
        return st;
    }
    public String GetProductId(int number)
    {
        var path = String.format("(//div[@class='product-cr'])[%s]", number);
        var element = findElement(By.xpath(path));
        return element.getAttribute("id");
    }
    /*public String GetFavoriteId(int number)
    {
        var element=findElement(By.xpath("(//div[@class='product-cr'])[%s]"));
        return element.getAttribute("id");
    }*/

    public static ArrayList<String> favoriteId = new ArrayList<String>();
    public static ArrayList<String> productId= new ArrayList<String>();

}
