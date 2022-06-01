package com.sample.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sample.*;
import com.sample.pages.HomePage;
import com.sample.pages.LoginPage;
import com.sample.utilities.TestUtil;

public class HomePageTest extends BaseClass {

    LoginPage loginPage;
    HomePage homePage;

    @BeforeClass
    @Parameters({ "url", "browserName" , "headless"})
    public void browserStart(@Optional("https://www.amazon.in/") String url,
                                  @Optional("chrome") String browserName, @Optional("false") String headless) {
        launchPlaywright(browserName, headless);
        launchApplication(url);
        loginPage = new LoginPage(page);
        homePage = loginPage.login("9550927319", "Admin@123");
        
        //commenet
    }
    
    @Test
    public void verifyUserNameOnHomePage() {
    	homePage = new HomePage(page);
        String Username = homePage.GetUserNameOnHomePage();
        Assert.assertEquals("Hello, Vani", Username);
    }
    
    @DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData("contacts");
		return data;
	}
	
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void addNewCardsToAccount(String CardNumber, String Name, String Month, String Year){
		System.out.println(CardNumber + Name + Month + Year);
		
	}

    @AfterClass
    public void browserClose() {
        closePlaywright();
    }

}
