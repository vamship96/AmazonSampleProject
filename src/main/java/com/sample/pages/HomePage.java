package com.sample.pages;

import static org.testng.Assert.assertEquals;

import com.microsoft.playwright.Page;

public class HomePage {
	 private final Page page;

	    String usernameBox = "#login-username";
	    String usernameLocator = "#nav-link-accountList-nav-line-1";

	    public HomePage(Page page) {
	        this.page = page;
	    }

	    public String GetUserNameOnHomePage() {
	    	System.out.println("waiting for username in home page");
	    	return page.locator(usernameLocator).textContent();
	    }
}
