package com.sample.tests;


import org.testng.ITestContext;		
import org.testng.ITestListener;		
import org.testng.ITestResult;

import com.microsoft.playwright.Page;
import com.sample.pages.LoginPage;

public class CustomListener extends BaseClass implements ITestListener {
	LoginPage loginPage;

	@Override		
    public void onFinish(ITestContext Result) 					
    {		
                		
    }		

    @Override		
    public void onStart(ITestContext Result)					
    {		
            		
    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result)					
    {		
    		
    }		

    // When Test case get failed, this method is called.		
    @Override		
    public void onTestFailure(ITestResult Result) 					
    {		
    System.out.println("The name of the testcase failed is :"+Result.getName());
    System.out.println(Result.getName()+" test case started");
    String methodName = Result.getName();
    loginPage = new LoginPage(page);
    	//loginPage.takeScreenShot(methodName);
    }		

    // When Test case get Skipped, this method is called.		
    @Override		
    public void onTestSkipped(ITestResult Result)					
    {		
    System.out.println("The name of the testcase Skipped is :"+Result.getName());					
    }		

    // When Test case get Started, this method is called.		
    @Override		
    public void onTestStart(ITestResult Result)					
    {		
    
    }		

	// When Test case get passed, this method is called.		
    @Override		
    public void onTestSuccess(ITestResult Result)					
    {		
    System.out.println("The name of the testcase passed is :"+Result.getName());					
    }
}
