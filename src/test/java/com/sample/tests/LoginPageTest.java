package com.sample.tests;

import com.sample.pages.HomePage;
import com.sample.pages.LoginPage;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(CustomListener.class)

public class LoginPageTest extends BaseClass {
    LoginPage loginPage;
    HomePage homePage;

    @BeforeClass
    //@Parameters({ "url", "browserName" , "headless"})
    public void browserStart() {
    	String browserName = prop.getProperty("browserName");
    	String headless = prop.getProperty("headless");
    	String url = prop.getProperty("url");
        launchPlaywright(browserName, headless);
        launchApplication(url);
    }

    @Test(priority = 1)
    public void loginTest() throws InterruptedException {
    	String username = prop.getProperty("username");
    	String password = prop.getProperty("password");
        loginPage = new LoginPage(page);
        homePage = loginPage.login(username, password);
    }

    @AfterClass
    public void browserClose() {
        closePlaywright();
    }
}
