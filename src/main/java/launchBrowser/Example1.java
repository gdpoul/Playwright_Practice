package launchBrowser;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Example1 {
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		
//		LaunchOptions lp = new LaunchOptions().setChannel("chrome").setHeadless(false);
	    
	    Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
	    
		Page page=browser.newPage();		
		page.navigate("https://opensource-demo.orangehrmlive.com/");

	
	}

}
