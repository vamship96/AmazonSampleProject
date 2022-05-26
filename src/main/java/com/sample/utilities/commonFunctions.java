package com.sample.utilities;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import PageObjects.*;



public class commonFunctions {

	Locator locator = null;
	
	protected final Page page;

	 public commonFunctions(Page page)
	 {
		this.page = page;
		 
	 }
	 
	 
	 public void clickifElementPresent(PageObjects pageObject)
	 {
		 
		String strObjName = pageObject.getObjectname();
		
		String element;
		
		try {
			element = pageObject.getProperty();

			page.locator(element).click();
			
			System.out.println(strObjName + " Present and Clicked");
		}
		catch (Exception e) {
			System.out.println(strObjName + " Not Found");
		}
		
	 }
	 
	 public void clearAndEnterText(PageObjects pageObject, String keys)
	 {
		 String strObjName = pageObject.getObjectname();
			
			String element;
			
			element = pageObject.getProperty();
			
			try {
				
				if(element != null)
				{
				page.locator(element).fill(keys);
				
				System.out.println(strObjName + " Present and Clicked");
				}
				else
				{
					System.out.println(strObjName + " not found");
				}
			}
			catch (Exception e) {
				System.out.println("Unable to enter values " + strObjName);
			}
	 }
}
