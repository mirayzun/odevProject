package com.testinium.tests;

import com.testinium.driver.BaseTest;
import com.testinium.pages.ProductPage;
import org.apache.logging.log4j.core.config.Order;
import org.junit.Test;
@Order(3)
public class ProductPageTest extends BaseTest {
    ProductPage productPage;
    @Test
    public void favProductTest(){
       productPage= new ProductPage();
       productPage.favProduct();
    }
    @Test
    public void worldClasSortTest(){
        productPage= new ProductPage();
        productPage.worldClasSort();
    }
    @Test
    public void hobiPageRandomTest(){
        productPage= new ProductPage();
        productPage.hobiPageRandom();

    }

}
