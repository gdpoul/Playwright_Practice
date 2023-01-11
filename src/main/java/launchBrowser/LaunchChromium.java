package launchBrowser;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchChromium {
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://www.amazon.com");
		
		String title=page.title();
		System.out.println("page title is :"+title);
		
		String url = page.url();
		System.out.println("page url is :"+url);
		
		System.out.println(browser.version());
		browser.close();
		playwright.close();
	}

}
