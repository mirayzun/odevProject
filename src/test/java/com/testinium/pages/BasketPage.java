package com.testinium.pages;

import com.testinium.methods.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
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
    public void productSellStep(){
        productSell();
        method.click(By.xpath("//button[@id='button-checkout-continue']"));
        method.click(By.xpath("//button[@id='button-checkout-continue']"));
        method.sendKeys(By.xpath("//input[@id='credit-card-owner']"),"Miray Zunbulova");
        method.sendKeys(By.xpath("//credit_card_number_1']"),"5269");
        method.sendKeys(By.xpath("//credit_card_number_2']"),"5508");
        method.sendKeys(By.xpath("//credit_card_number_3']"),"2308");
        method.sendKeys(By.xpath("//credit_card_number_4']"),"8017");
        method.selectByText(By.cssSelector("select#credit-card-expire-date-month"),"01");
        method.selectByText(By.cssSelector("credit-card-expire-date-year"),"2023");
        method.sendKeys(By.xpath("//input[@id='credit-card-security-code']"),"181");
        method.click(By.xpath("//button[@id='button-checkout-continue']"));
        method.click(By.xpath("//input[@type='checkbox']"));
        method.click(By.xpath("//input[@type='submit']"));
        Assert.assertEquals("kart bilgisi ","Kart bilgileriniz doğrulanamadı, lütfen tekrar deneyiniz.",method.getSelect(By.xpath("//div[@class='warning']")));

    }
}
