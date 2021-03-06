package com.sample.tests;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;


public class BaseClass {

    Playwright playwright;
    BrowserType browserType;
    Browser browser;
    BrowserContext context;
    public static Properties prop;
    protected Page page;
    
    public BaseClass(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/sample"
					+ "/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public void launchPlaywright(String browserName, String headless) {
        playwright = Playwright.create();
        if (browserName.equalsIgnoreCase("chrome") || browserName.equalsIgnoreCase("msedge")
                || browserName.equalsIgnoreCase("chromium")) {
            browserType = playwright.chromium();
        } else if (browserName.equalsIgnoreCase("webkit")) {
            browserType = playwright.webkit();
        }
        if (headless.equalsIgnoreCase("true")) {
            browser = browserType.launch(new BrowserType.LaunchOptions().setChannel(browserName).setSlowMo(2000).setHeadless(true));
        } else {
            browser = browserType.launch(new BrowserType.LaunchOptions().setChannel(browserName).setSlowMo(2000).setHeadless(false));
        }
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1400, 700));
        context.tracing().start(new Tracing.StartOptions()
        		  .setScreenshots(true)
        		  .setSnapshots(true));
        
        page = context.newPage();
    	
        System.out.println("**** Project Browser Name and Version is : " + browserName + " : " + browser.version());
    }

    public void launchApplication(String url) {
        page.navigate(url);
    }
    
    public void takeScreenshot(String name) {
    	System.out.println(name + "failed");
    }
    

    public void closePlaywright() {
        page.close();
        browser.close();
        playwright.close();
    }

}

