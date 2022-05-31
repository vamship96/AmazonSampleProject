package com.sample.pages;

import com.microsoft.playwright.Page;
import com.sample.utilities.commonFunctions;

import PageObjects.loginPageObject;
import PageObjects.loginPageObject.*;


public class LoginPage extends commonFunctions {

public LoginPage(Page page) {
		super(page);
		// TODO Auto-generated constructor stub
	}

//private static final Page page = null;


//    private final Page page;
    HomePage homePage;
    
    
    String signInButton = "Hello, Sign in";
    String usernameBox = "//input[@id='ap_email']";
    String passwordBox = "#ap_password";
    String loginButton = "#signInSubmit";
    
    //input[@id='ap_password']
//    
//
//    public LoginVWOPage(Page page) {
//        this.page = page;
//        
//    }
    commonFunctions commonFunction = new commonFunctions(page);

    public HomePage login(String username, String password) {
        boolean isLoginSuccess = false;
        commonFunction.clickifElementPresent(loginPageObject.btn_SignIn);
        
        commonFunction.clearAndEnterText(loginPageObject.txtBx_UserName, username);
        
        commonFunction.clickifElementPresent(loginPageObject.btn_Continue);

        commonFunction.clearAndEnterText(loginPageObject.txtBx_Password, password);

        commonFunction.clickifElementPresent(loginPageObject.btn_Submit);
        
        boolean isEnabled = page.isEnabled("input");
        if (isEnabled) {
            isLoginSuccess = true;
        }
    	
    	
        return homePage;
    }
}