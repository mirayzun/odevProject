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
}
