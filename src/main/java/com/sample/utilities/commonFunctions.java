package com.sample.utilities;

import static org.testng.Assert.fail;

import org.testng.Assert;

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
				
				System.out.println(strObjName + " Present and " +keys + " values entered");
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
	 
	 public String getTextFromElement(PageObjects pageObject)
	 {
		 	String strObjName = pageObject.getObjectname();
			
			String element;
			
			String text = null;
			
			element = pageObject.getProperty();
			
			try {
				if(element != null)
				{
				text = page.locator(element).textContent();
				
				System.out.println(strObjName + " Present and Clicked");
				}
				
			}
			catch (Exception e) {
				System.out.println(strObjName + " Element not found");
			}
			
			return text;
	 }
	 
	 public void elementPresentEqualsText(PageObjects pageObject, String matchText)
	 {
		 	String strObjName = pageObject.getObjectname();
			if(getTextFromElement(pageObject).equalsIgnoreCase(matchText))
			{
				System.out.println(strObjName + " matched with " + matchText);
			}
			else
			{
				System.out.println(strObjName + " not matched with " + matchText);
				Assert.fail("this step is failed");
			}
			
	 }
	 
	 public void selectDropdownfromValue(PageObjects droppdown, PageObjects option)
	 {
		 String dropDownelement, dropdownOption;
		 
		 dropDownelement = droppdown.getProperty();
		 
		 dropdownOption = option.getProperty();
		 
		 String dropDownelementName = droppdown.getObjectname();
		 
		 String dropdownOptionName = option.getObjectname();
		 
		 if(dropDownelement != null)
		 {
			 if(dropdownOption != null)
			 {
				 page.selectOption(dropDownelement, dropdownOption);
				 System.out.println(dropdownOptionName + " Selected From " + dropDownelementName);
			 }
			 else
			 {
				 System.out.println(dropdownOptionName + " not found");
			 }
		 }
		 else
		 {
			 	System.out.println(dropDownelementName + " not found");
		 }
		 
	 }
	 
	 public void pressKey(String key)
	 {
		 try {
			 if(key!=null)
			 {
				 page.keyboard().press(key);
			 }
		 }
		catch (Exception e) {
			System.out.println(e);
		} 
	 }
	 
	 public boolean verifyElementDisplayed(PageObjects pageObject)
	 {
		 
		String element = pageObject.getProperty();
		
		String strObjName = pageObject.getObjectname();
		 
		 
		 try {
			 if(page.isVisible(element))
			 {
				 System.out.println(strObjName + "Is visible");
			 }
			 return true;
		 }
		 catch (Exception e) {
			System.out.println(e);
			return false;
		}
	 }
	 
	 public void hoverOverElement(PageObjects pageObject)
	 {
		String element = pageObject.getProperty();
			
		String strObjName = pageObject.getObjectname();
		
		if(page.isVisible(element))
		 {
			page.hover(element);
			
			System.out.println(strObjName + "Is visible and Hovered");
		 }
		else
		{
			System.out.println(strObjName + "Is not visible");
		}
	 }
}
