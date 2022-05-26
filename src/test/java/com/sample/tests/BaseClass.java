package com.sample.tests;


import java.nio.file.Paths;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;


public class BaseClass {

    Playwright playwright;
    BrowserType browserType;
    Browser browser;
    BrowserContext context;
    protected Page page;

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
//            browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("app.login.json")));
//            context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("app.login.json")));
        } else {
            browser = browserType.launch(new BrowserType.LaunchOptions().setChannel(browserName).setSlowMo(2000).setHeadless(false));
//            browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("app.login.json")));
        }
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1400, 700));
//        context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("app.login.json")));
//        browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("app.login.json")));
        context.close();
        page = browser.newPage();
        System.out.println("**** Project Browser Name and Version is : " + browserName + " : " + browser.version());
    }

    public void launchApplication(String url) {
//        page.navigate(url, new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));
        page.navigate(url);
//        page.waitForSelector("[data-qa='cemaxumuwu']");
    }

    public void closePlaywright() {
        page.close();
        browser.close();
        playwright.close();
    }

}

