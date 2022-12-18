package com.testinium.tests;

import com.testinium.driver.BaseTest;
import com.testinium.pages.AccountPage;
import com.testinium.pages.LoginPage;
import org.apache.logging.log4j.core.config.Order;
import org.junit.Test;
@Order(2)
public class AccountPageTest extends BaseTest {
    AccountPage accountPage;
    @Test
    public void LoginControlTest(){
       accountPage= new AccountPage();
       accountPage.loginControl();
    }
    @Test
    public void AddAddressTest(){
        accountPage = new AccountPage();
        accountPage.addAddress();
    }
}
