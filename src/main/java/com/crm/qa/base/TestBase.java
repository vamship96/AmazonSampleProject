package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.crm.qa.util.TestUtil;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestBase {
	
	public static Page page;
	public static Properties prop;
	//public  static EventFiringWebDriver e_driver;
	//public static WebEventListener eventListener;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/crm"
					+ "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			try (Playwright playwright = Playwright.create()) {
			      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(5000).setChannel("chrome"));			      
//			      page = browser.newPage();
//			      page.navigate("http://playwright.dev");
			    }
		}
		else if(browserName.equals("Safari")){
			try (Playwright playwright = Playwright.create()) {
			      Browser browser = playwright.webkit().launch(
			    		  new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(5000));
//			      page = browser.newPage();
//			      page.navigate("http://playwright.dev");
			
		}	
		
	}
	}
}
