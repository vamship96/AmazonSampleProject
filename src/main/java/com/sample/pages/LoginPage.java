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

    HomePage homePage;
    
    
    String signInButton = "Hello, Sign in";
    String usernameBox = "//input[@id='ap_email']";
    String passwordBox = "#ap_password";
    String loginButton = "#signInSubmit";
    
    commonFunctions commonFunction = new commonFunctions(page);

    public HomePage login(String username, String password) throws InterruptedException {
        boolean isLoginSuccess = false;
        commonFunction.clickifElementPresent(loginPageObject.btn_SignIn);
        
        commonFunction.clearAndEnterText(loginPageObject.txtBx_UserName, username);
        
        commonFunction.clickifElementPresent(loginPageObject.btn_Continue);

        commonFunction.clearAndEnterText(loginPageObject.txtBx_Password, password);

        commonFunction.clickifElementPresent(loginPageObject.btn_Submit);
        
   	
        Thread.sleep(1000);
        return homePage;
    }
}