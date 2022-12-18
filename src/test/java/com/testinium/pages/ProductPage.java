package com.testinium.pages;

import com.testinium.methods.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Random;

public class ProductPage {
    Method method;
    HomePage homePage;
    AccountPage accountPage;
    LoginPage loginPage;
    CatalogPage catalogPage;
    Logger logger = LogManager.getLogger(ProductPage.class);
    ArrayList<WebElement> favList= new ArrayList<WebElement>();

    public ProductPage(){

        method = new Method();
    }
    /* CASE
    "https://www.kitapyurdu.com/" adresine git
    hobi&oyuncak menüsüne tıkla
    Montessori oyuncaklarına tıkla
    7. ürüne scrol yap
    4 ürün favorilere ekle
     */
    public void favProduct() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        loginPage.login();
        var trueLog = method.isElementVisible(By.cssSelector(".section"));
        if (trueLog == false) {
            loginPage.login();
        }
        homePage.Search();

        var scroll = "(//div[@id='product-table']/div[@class='product-cr'])";



        method.scrollWithAction(By.xpath(scroll + "[7]"));
        logger.info("7. urune scroll yapıldı");

        method.click(By.xpath(method.AddFavoritesXPath(7)));
        method.waitBySeconds(1);
        Method.favoriteId.add(method.GetProductId(7));
        logger.info("birinci urun favorilere eklendi");


        method.click(By.xpath(method.AddFavoritesXPath(8)));
        method.waitBySeconds(1);
        Method.favoriteId.add(method.GetProductId(8));
        logger.info("ikinci urun favorilere eklendi");


        method.click(By.xpath(method.AddFavoritesXPath(9)));
        method.waitBySeconds(1);
        Method.favoriteId.add(method.GetProductId(9));
        logger.info("ucuncu urun favorilere eklendi");


        method.click(By.xpath(method.AddFavoritesXPath(10)));
        method.waitBySeconds(1);
        Method.favoriteId.add(method.GetProductId(10));
        logger.info("dorduncu urun favorilere eklendi");
    }
    /* CASE
    "https://www.kitapyurdu.com/" adresine git
    Puan katologuna tıkla
    dünya klasikleri seçilir
    yüksek oylama seçilir
     */

    public void worldClasSort(){
        catalogPage= new CatalogPage();
        catalogPage.TurkClas();
        method.selectByText(By.cssSelector(".product-filter-header select"),"Yüksek Oylama");
        logger.info("yuksek oylama secildi");
    }
    public void hobiPageRandom()
    {
        method.getPage("https://www.kitapyurdu.com/kategori/kitap-hobi/1_212.html");
        var min = 1;
        var max = 10;
        var randomNumber = new Random().nextInt(max) + min;
        var path = String.format("(//div[@class='product-cr'])[%s]", randomNumber);
        method.click(By.xpath(path));
        method.waitBySeconds(1);
        method.click(By.xpath("//a[@id='button-cart']"));
    }




}
