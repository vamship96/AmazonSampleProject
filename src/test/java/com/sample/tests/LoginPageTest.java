package com.sample.tests;

import com.sample.pages.HomePage;
import com.sample.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPageTest extends BaseClass {
    LoginPage loginPage;
    HomePage homePage;

    @BeforeClass
    @Parameters({ "url", "browserName" , "headless"})
    public void browserStart(@Optional("https://www.amazon.in/") String url,
                                  @Optional("chrome") String browserName, @Optional("false") String headless) {
        launchPlaywright(browserName, headless);
        launchApplication(url);
    }

    @Test(priority = 1)
    @Parameters({ "username", "password" })
    public void loginTest(@Optional("9550927319") String username, @Optional("Admin@123") String password) {
        loginPage = new LoginPage(page);
        homePage = loginPage.login(username, password);
    }

    @AfterClass
    public void browserClose() {
        closePlaywright();
    }
}
