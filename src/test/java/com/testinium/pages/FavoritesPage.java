package com.testinium.pages;

import com.testinium.methods.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.text.Format;
import java.util.ArrayList;
import java.util.Arrays;

import static com.testinium.methods.Method.favoriteId;

public class FavoritesPage {

    Method method;
    Logger logger;
    HomePage homePage;
    LoginPage loginPage;

    public FavoritesPage(){
        method= new Method();
        loginPage = new LoginPage();
        homePage =new HomePage();
    }

    public void getFavoritesPage(){
    homePage.getHome();
    loginPage.login();
    method.getPage("https://www.kitapyurdu.com/index.php?route=account/favorite&selected_tags=0");
    }
    /* CASE
    "https://www.kitapyurdu.com/" adresine git
    listelerime tıkla
    login kontrolü yap
    favorilerimi listesine tıkla
    listeye eklediğin 4 ürünü kontrol et
     */
    public  void getFavoritesControl(){
        getFavoritesPage();
        method.productId.add(method.GetProductId(1));
        method.productId.add(method.GetProductId(2));
        method.productId.add(method.GetProductId(3));
        method.productId.add(method.GetProductId(4));

        for (String item :  method.productId) {
            var finded = method.favoriteId.stream().filter(t-> t.equals(item)).toString();
            if(finded != null){

            }
        }

    }
    /* CASE
    favoriler sayfasından
    "https://www.kitapyurdu.com/" adresine git
     */
    public void getHomepage(){
        homePage.getHome();
    }
    /* CASE
    "https://www.kitapyurdu.com/" adresine git
    listelerime tıkla
    login kontrolü yap
    favorilerimi listesine tıkla
    3. ürün sil
     */
    public void favoriteRemove(){
        getFavoritesPage();
        var uniqId= method.GetProductId(3);
        var xpath = String.format("(//div[@id='%s'])", uniqId) + "//div[@class='hover-menu']/a[@data-title='Favorilerimden Sil']";
        var element = method.findElement(By.xpath(xpath));
        method.click(By.xpath(xpath));
    }

}
