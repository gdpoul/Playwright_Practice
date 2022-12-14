package launchBrowser;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;


public class LaunchMsEdge {

	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		
		LaunchOptions lp=new LaunchOptions();
		lp.setChannel("msedge");
		lp.setHeadless(false);
		
		Browser browser = playwright.chromium().launch(lp);
		Page page = browser.newPage();
		page.navigate("https://www.flipkart.com");
		
		String title=page.title();
		System.out.println("page title is :"+title);		
		String url = page.url();
		System.out.println("page url is :"+url);

		System.out.println(browser.version());
		browser.close();
	    playwright.close();

		
		
	}
}
