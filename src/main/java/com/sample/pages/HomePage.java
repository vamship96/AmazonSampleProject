package com.sample.pages;

import static org.testng.Assert.assertEquals;

import java.awt.event.MouseEvent;
import java.nio.file.Paths;
import java.util.Iterator;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.sample.utilities.commonFunctions;

import PageObjects.HomePageObjects;
import PageObjects.HomePageObjects.*;

public class HomePage extends commonFunctions{

	    String usernameBox = "#login-username";
	    String usernameLocator = "#nav-link-accountList-nav-line-1";

	    public HomePage(Page page) {
			super(page);
	    }
	    
	    commonFunctions commonFunction=new commonFunctions(page);    

	    public void GetUserNameOnHomePage(String matchtext) {
	    	
	    	System.out.println("waiting for username in home page");
	    	
	    	commonFunction.elementPresentEqualsText(HomePageObjects.txt_Username, matchtext);
	    }
	    
	    public void selectElectronics() throws InterruptedException {
	    	commonFunction.selectDropdownfromValue(HomePageObjects.input_drpDwn, HomePageObjects.opt_Dropdown);
	    }
	    
	    
	    public void enterRequiredSearchValue(String string) throws InterruptedException {
	    	commonFunction.clearAndEnterText(HomePageObjects.txtBx_SearchBox, string);
	    	
	    	commonFunction.pressKey("ArrowDown");
	    	
	    	commonFunction.pressKey("Enter");
	    	
	    	Thread.sleep(3000);
	    	
	    }
	    
	    
	    public String clickRequiredItem(String device, String Storage, String color) throws InterruptedException {

	    	String deviceLocator = "";
	    	
	    	Locator devices = page.locator("//span[@class='a-size-medium a-color-base a-text-normal']");
	    	System.out.println(devices.count());
	    	
	    	for(int i=1; i<=devices.count(); i++) {
	    		String deviceName = devices.nth(i).textContent();
	    		System.out.println(deviceName);
	    		if(deviceName.contains(device) && deviceName.contains(Storage) && deviceName.contains(color)) {
	    				deviceLocator = "(//span[contains (text(), '"+device+"') and contains (text(), '"+Storage+"') and  contains (text(), '"+color+"')]/parent::a)[1]";
	    				System.out.println(deviceLocator);
	    				break;
	    		} else {
	    			continue;
	    		}
	    	}
	    	
	    	String loc = "";
	    	
	    	//System.out.println(deviceName);
	    	
	    	page.hover(deviceLocator);
	    	
	    	loc = page.getAttribute(deviceLocator, "href");
	    	
	    	String linkOfProduct = "";
	    	
	    	linkOfProduct= "https://www.amazon.in/"+page.getAttribute(deviceLocator, "href");

	    	System.out.println(linkOfProduct);
	    	
	    	page.navigate(linkOfProduct);
			
	    	return linkOfProduct;
	    }

	    public void addToCart() throws InterruptedException {
	    	
	    	commonFunction.clickifElementPresent(HomePageObjects.btn_AddToCart);
	    	

	    	Thread.sleep(3000);
	    	
	    	if(commonFunction.verifyElementDisplayed(HomePageObjects.btn_CartOnOverlay))
	    	{
	    		commonFunction.clickifElementPresent(HomePageObjects.btn_CartOnOverlay);
	    	}
	    	
	    }
	    
	    public void navigateToMyAccounts() {
	    	
	    	commonFunction.hoverOverElement(HomePageObjects.lnk_AccountList);
	    	
	    	commonFunction.clickifElementPresent(HomePageObjects.opt_YourAccount);
	    }
	    
	    public void selectPayemntOptions() {
	    	commonFunction.clickifElementPresent(HomePageObjects.btn_PaymentOptions);
	    }
	    
	    public void verifySavedCardsPresent()
	    {
	    	if(commonFunction.verifyElementDisplayed(HomePageObjects.hdr_SavedCards)) {
	    		System.out.println("Saved cards are present");
	    	}
	    	else {
	    		System.out.println("There are No Saved Cards");
	    	}
	    }
	    
	    public void clickOnAddDebitCreditCard() {
	    	
	    	commonFunction.verifyElementDisplayed(HomePageObjects.hdr_CreditDebitCardPopUp);
	    }
	    
	    public void enterCreditDebitCardDetails(String cardNumber, String cardName) throws InterruptedException {
	    	commonFunction.clickifElementPresent(HomePageObjects.btn_AddDebitOrCreditCard);
	    	
	    	Thread.sleep(3000);
	    	
	    	Locator cardNumberTxt = page.frameLocator(".apx-secure-iframe").locator("//input[@name='addCreditCardNumber']");
	    	cardNumberTxt.click();
	    	cardNumberTxt.fill(cardNumber);
	    	
	    	Locator name = page.frameLocator(".apx-secure-iframe").locator("//input[@name='ppw-accountHolderName']");
		    name.click();
		    name.fill(cardName);
		      
		    Locator month = page.frameLocator(".apx-secure-iframe").locator("//span[@class='a-dropdown-prompt']").first();
		    month.click();
		      
		    Locator monthSelection = page.frameLocator(".apx-secure-iframe").locator("//a[text()='02']");
		    monthSelection.click();
		      
		    Locator year = page.frameLocator(".apx-secure-iframe").locator("//span[@class='a-dropdown-prompt']").last();
		    year.click();
		      
		    Locator yearSelection = page.frameLocator(".apx-secure-iframe").locator("//a[text()='2026']");
		    yearSelection.click();
		    
		    page.frameLocator(".apx-secure-iframe").locator("text=Cancel").click();
	    }
	    
	    public void navigateToCart() {
	    	commonFunction.clickifElementPresent(HomePageObjects.btn_GlobalCart);
	    }
	    
	    public void verifyDevicePresentInCart(String device, String Storage, String color) {
	    	try {
                commonFunction.clickifElementPresent(HomePageObjects.lnk_SelectAll);
                commonFunction.clickifElementPresent(HomePageObjects.lnk_DeselectAll);
            }

            catch (Exception e) {
                commonFunction.clickifElementPresent(HomePageObjects.lnk_DeselectAll);
            }
            String dev = "(//span[contains (text(), '"+device+"') and contains (text(), '"+Storage+"') and  contains (text(), '"+color+"')]/ancestor::div[@class='sc-list-item-content']/div/div/label/i)[1]";
            page.click(dev);
	    	
	    }
	    
}