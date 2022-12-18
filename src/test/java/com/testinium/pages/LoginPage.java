package com.testinium.pages;

import com.testinium.methods.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage {
    Method method;
    Logger logger = LogManager.getLogger(LoginPage.class);
    public LoginPage(){
        method = new Method();

    }
    /* CASE
    "https://www.kitapyurdu.com/" adresine git
    login butonu tıkla
    email gir
    sifre gir
    giris yap butonuna tıkla
     */
    public void login(){
        method.getPage("https://www.kitapyurdu.com/");
        method.click(By.cssSelector(".menu-top-button.login>a"));
        method.sendKeys(By.id("login-email"),"sevvalmiray.zunbulova@testinium.com");
        method.sendKeys(By.xpath("//input[@id='login-password']"),"1q2w3e4r5t");
        method.click(By.cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn"));
        Assert.assertTrue(method.isElementVisible(By.cssSelector(".section")));
        logger.info("login basarili");
    }
}
