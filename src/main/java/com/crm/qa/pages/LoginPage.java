package com.crm.qa.pages;
import com.crm.qa.base.TestBase;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class LoginPage extends TestBase{
	
	String title;
	
	public static void initialization(){
		
		
		
	}
	
	
	public String validateLoginPageTitle(){
		Page page = Browser.NewPage()
		return title;
	}
	
	
	
	//public HomePage login(String un, String pwd){
		//System.out.println(un+ " " + " " + pwd);
		//return new HomePage();
	//}
	
}
