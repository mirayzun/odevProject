package com.testinium.driver;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    public static WebDriver mDriver;
    ChromeOptions chromeOptions = new ChromeOptions();
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-translate");

        mDriver= new ChromeDriver(chromeOptions);
        mDriver.manage().window().maximize();
        //mDriver.get("https://www.kitapyurdu.com/");
    }
    @After
    public void TearDown(){
        if(mDriver !=null){
            mDriver.quit();
        }
    }
}
