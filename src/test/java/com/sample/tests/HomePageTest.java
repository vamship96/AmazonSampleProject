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
    
    @Test
    public void verifyUserNameOnHomePage() {
    	homePage = new HomePage(page);
    	String displayName = prop.getProperty("password");
        homePage.GetUserNameOnHomePage(displayName);
    }
    

	@Test(priority = 4)
	public void searchforParticularItem() throws InterruptedException
	{
		homePage.selectElectronics();
		String searchKey = prop.getProperty("searchKey");
    	String ResultKey1 = prop.getProperty("ResultKey1");
    	String ResultKey2 = prop.getProperty("ResultKey2");
    	String ResultKey3 = prop.getProperty("ResultKey3");
    	
		homePage.enterRequiredSearchValue(searchKey);
		homePage.clickRequiredItem(ResultKey1,ResultKey2, ResultKey3);
		homePage.addToCart();
	}
	
//	@Test(priority = 5)
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
//	
//	@Test(priority = 6)
//	public void verifyItemAddedToCart()
//	{
//		homePage.navigateToCart();
//		String ResultKey1 = prop.getProperty("ResultKey1");
//    	String ResultKey2 = prop.getProperty("ResultKey2");
//    	String ResultKey3 = prop.getProperty("ResultKey3");
//		homePage.verifyDevicePresentInCart(ResultKey1,ResultKey2, ResultKey3);
//	}
//	
//    @DataProvider
//	public Object[][] getCRMTestData(){
//		Object data[][] = TestUtil.getTestData("contacts");
//		return data;
//	}
//	
//	
//	@Test(priority=7, dataProvider="getCRMTestData")
//	public void addNewCardsToAccount(String CardNumber, String Name, String Month, String Year){
//		System.out.println(CardNumber + Name + Month + Year);	
//	}
	
    @AfterClass
    public void browserClose() {
        closePlaywright();
    }

}
