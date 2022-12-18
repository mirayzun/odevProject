package com.testinium.tests;
import com.testinium.driver.BaseTest;
import com.testinium.pages.HomePage;
import org.apache.logging.log4j.core.config.Order;
import org.junit.Test;

@Order(0)
public class HomePageTest extends BaseTest {
    HomePage homePage;
    @Test
    public void HomePageTest(){
       homePage = new HomePage();
       homePage.getHome();
    }
    @Test
    public void SearchTest(){
        homePage=new HomePage();
        homePage.Search();
    }
    @Test
    public void PointPageTest(){
        homePage= new HomePage();
        homePage.pointPage();
    }
    @Test
    public void allBookandHobiTest(){
        homePage= new HomePage();
        homePage.allBookandHobi();
    }
    @Test
    public void logOutTest(){
        homePage= new HomePage();
        homePage.logOut();
    }

}
