package com.testinium.pages;

import com.testinium.methods.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;


public class AccountPage {
    Method method;
    Logger logger = LogManager.getLogger(AccountPage.class);
    LoginPage loginPage;
    public AccountPage(){
        method= new Method();
        loginPage= new LoginPage();
    }
    /* CASE
    "https://www.kitapyurdu.com/" adresine git
    login butonu tıkla
    email gir
    sifre gir
    giris yap butonuna tıkla
    hakkimda title kontrol et
     */
    public void loginControl(){
        loginPage.login();
        Assert.assertTrue(method.isElementVisible(By.cssSelector(".section")));
        logger.info("hesap kontorlu saglandi");
    }
    /* CASE
    "https://www.kitapyurdu.com/" adresine git
    login kontrolu
    merhaba ad-soyad alanına tıklan
    hesabım butonuna tıkla
    adreslerim alnına gel
    yeni adres ekle tıkla
    formu doldur
    gönder butonuna tıkla
     */
    public void addAddress()
    {
        loginPage.login();
        method.click(By.xpath("//i[@class='fa fa-map-marker fa-fw']"));
        method.click(By.xpath("//a[@class='button']"));
        method.sendKeys(By.xpath("//input[@id='address-firstname-companyname']"),"Miray");
        method.sendKeys(By.xpath("//input[@id='address-lastname-title']"),"Zunbulova");
        method.selectByText(By.cssSelector("select#address-zone-id"),"Bursa");
        method.waitBySeconds(1);
        method.selectByText(By.cssSelector("select#address-county-id"),"OSMANGAZİ");
        method.sendKeys(By.xpath("//textarea"),"Bursa Osmangazi Doburca Mah");
        method.sendKeys(By.xpath("//input[@id='address-mobile-telephone']"),"5313435591");
        method.click(By.xpath("//input[@type='submit']"));
    }

}
