package com.testinium.pages;

import com.testinium.methods.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class BasketPage {
    Method method;
    HomePage homePage;
    Logger logger = LogManager.getLogger(LoginPage.class);

    public BasketPage(){
        method= new Method();
        homePage= new HomePage();
    }
    /*CASE
    "https://www.kitapyurdu.com/" adresine git
    ana sayfadan sepete ürün ekle
    sepetim butonuna tıkla
    acilan menüden sepet sayfasina git
     */
    public void basketGetPage(){
    homePage.getHome();
    method.click(By.xpath("(//a[@data-title='Sepete Ekle'])[2]"));
    method.click(By.xpath("//a[@id='js-cart']"));
    }
    /*CASE
    "https://www.kitapyurdu.com/" adresine git
    ana sayfadan sepete ürün ekle
    sepetim butonuna tıkla
    acilan menüden sepet sayfasina git
    sayfadan degeri 10 yap
     */
    public void productNumber(){
        basketGetPage();
        method.sendKeys(By.xpath("//input[@name='quantity']"),"10");
    }
    public void productSell(){
        productNumber();
        method.click(By.xpath("//a[@class='button red']"));
    }
}
