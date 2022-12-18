package com.testinium.tests;

import com.testinium.driver.BaseTest;
import com.testinium.pages.BasketPage;
import org.junit.Test;

public class BasketPageTest extends BaseTest {
    BasketPage basketPage;
    @Test
    public void basketGetPageTest(){
        basketPage= new BasketPage();
        basketPage.basketGetPage();
    }
    @Test
    public void productNumberTest(){
        basketPage= new BasketPage();
        basketPage.productNumber();
    }
    @Test
    public void productSellTest(){
        basketPage= new BasketPage();
        basketPage.productSell();
    }
    @Test
    public void ProductSellStepTest(){
        basketPage= new BasketPage();
        basketPage.productSellStep();
    }
}
