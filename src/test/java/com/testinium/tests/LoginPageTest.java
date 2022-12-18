package com.testinium.tests;

import com.testinium.driver.BaseTest;
import com.testinium.pages.LoginPage;
import org.apache.logging.log4j.core.config.Order;
import org.junit.Test;

@Order(1)
public class LoginPageTest extends BaseTest {
    @Test
    public void LoginTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();
    }

}
