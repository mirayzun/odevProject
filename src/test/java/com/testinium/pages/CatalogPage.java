package com.testinium.pages;

import com.testinium.methods.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class CatalogPage {
    Method method;
    Logger logger = LogManager.getLogger(HomePage.class);
    HomePage homePage;
    public CatalogPage(){
        method= new Method();

    }
    /* CASE
    "https://www.kitapyurdu.com/" adresine git
    Puan katologuna tıkla
    dunya klasikleri seçilir
     */
    public void TurkClas()
    {
        homePage= new HomePage();
        homePage.pointPage();
        method.click(By.xpath("//img[@title='Puan Kataloğundaki Dünya Klasikleri']"));
    }

}
