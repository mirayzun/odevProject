package com.testinium.pages;
import com.testinium.driver.BaseTest;
import com.testinium.methods.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

    Method method;
    Logger logger = LogManager.getLogger(HomePage.class);
    LoginPage loginPage;
    public HomePage(){
        method= new Method();
        loginPage= new LoginPage();
    }
    /* CASE:
    "https://www.kitapyurdu.com/" adresine git
     */
    public void getHome(){
        method.getPage("https://www.kitapyurdu.com/");
        logger.info("homepage acildi");

    }
    /* CASE
    "https://www.kitapyurdu.com/" adresine git
    hobi&oyuncak mwenusune tikla
    Montessori oyuncaklarina tikla
     */
    public void Search(){
        method.getPage("https://www.kitapyurdu.com/");
        logger.info("homepage acildi");
        method.sendKeys(By.xpath("//input[@id='search-input']"),"oyuncak");
        logger.info("'oyuncak' search inputa yazildi");
        method.click(By.cssSelector(".common-sprite.button-search"));
        logger.info("search click yapildi");
    }
    /* CASE
    "https://www.kitapyurdu.com/" adresine git
    Puan katologuna tıkla
     */
    public void pointPage(){
        getHome();
        method.getPage("https://www.kitapyurdu.com/puan-katalogu");
    }
    /* CASE
    "https://www.kitapyurdu.com/" adresine git
    tüm kitaplar menüsüne tıklanır
    hobi kategorisi seçilir
     */
    public void allBookandHobi(){
        getHome();
        method.click(By.xpath("//span[text()='Tüm Kitaplar']"));
        method.click(By.xpath("//a[text()='Hobi']"));
    }
    /*
    "https://www.kitapyurdu.com/" adresine git
    login kontrolu
    merhaba ad-soyad alanına tıkla
    çıkış butonuna tıkla
     */
    public void logOut(){
        loginPage.login();
        WebElement element = method.findElement(By.cssSelector(".menu.top.login"));
        Actions action  = new Actions(BaseTest.mDriver);
        action.moveToElement(element).perform();
    }

}
