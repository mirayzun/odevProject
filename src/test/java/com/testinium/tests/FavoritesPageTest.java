package com.testinium.tests;

import com.testinium.driver.BaseTest;
import com.testinium.pages.FavoritesPage;
import org.apache.logging.log4j.core.config.Order;
import org.junit.Test;
@Order(4)
public class FavoritesPageTest extends BaseTest {
    FavoritesPage favoritesPage;
    @Test
    public void getFavoritesPageTest(){
        favoritesPage = new FavoritesPage();
        favoritesPage.getFavoritesPage();
    }
    @Test
    public void getFavoritesControlTest(){
        favoritesPage= new FavoritesPage();
        favoritesPage.getFavoritesControl();
    }
    @Test
    public void getHomepageTest(){
        favoritesPage= new FavoritesPage();
        favoritesPage.getHomepage();

    }
    @Test
    public void favoriteRemoveTest(){
        favoritesPage= new FavoritesPage();
        favoritesPage.favoriteRemove();
    }


}
