package com.sample.tests;

import java.nio.file.Paths;

import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import com.sample.*;
import com.sample.pages.HomePage;
import com.sample.pages.LoginPage;
import com.sample.utilities.TestUtil;

@Listeners(CustomListener.class)

public class HomePageTest extends BaseClass {

    LoginPage loginPage;
    HomePage homePage;

    @BeforeClass
    public void browserStart() throws InterruptedException {
    	String browserName = prop.getProperty("browserName");
    	String headless = prop.getProperty("headless");
    	String url = prop.getProperty("url");
    	String username = prop.getProperty("username");
    	String password = prop.getProperty("password");
        launchPlaywright(browserName, headless);
        launchApplication(url);
        loginPage = new LoginPage(page);

        homePage = loginPage.login(username, password);

    }
    
    @Test(priority = 1)
    public void verifyUserNameOnHomePage() {
    	homePage = new HomePage(page);
    	String displayName = prop.getProperty("displayName");
        homePage.GetUserNameOnHomePage(displayName);
    }
    
    @DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData("items");
		return data;
	}
	
	@Test(priority = 2, dataProvider="getCRMTestData")
	public void searchforParticularItem(String searchKey, String ResultKey1, String ResultKey2, String ResultKey3) throws InterruptedException
	{
		homePage.selectElectronics();
		homePage.enterRequiredSearchValue(searchKey);
		homePage.clickRequiredItem(ResultKey1,ResultKey2, ResultKey3);
		homePage.addToCart();
	}
	
//	@Test(priority = 3)
//	public void addPayementOptions() throws InterruptedException
//	{
//		homePage.navigateToMyAccounts();
//		homePage.selectPayemntOptions();
//		homePage.verifySavedCardsPresent();
//		homePage.clickOnAddDebitCreditCard();
//		
//		String crediCardNumber = prop.getProperty("crediCardNumber");
//    	String nameOnCard = prop.getProperty("nameOnCard");
//		homePage.enterCreditDebitCardDetails(crediCardNumber, nameOnCard);
//	}
	
	@Test(priority = 4,  dataProvider="getCRMTestData")
	public void verifyItemAddedToCart(String searchKey, String ResultKey1, String ResultKey2, String ResultKey3) throws InterruptedException
	{
		homePage.navigateToCart();
		homePage.verifyDevicePresentInCart(ResultKey1,ResultKey2, ResultKey3);
	}
	
    @AfterClass
    public void browserClose() {
    	context.tracing().stop(new Tracing.StopOptions()
    			  .setPath(Paths.get("trace.zip")));
        closePlaywright();
    }

}
