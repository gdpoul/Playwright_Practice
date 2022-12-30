package locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HasText {
	public static void main(String[] args) {
		
		Playwright playwright =Playwright.create();
		Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext browserContext= browser.newContext();
		Page page=browserContext.newPage();	
		page.navigate("https://demo.opencart.com/index.php?route=account/login");
		
		String header=page.locator("h2:has-text('New Customer')").textContent();
//		String header=page.locator("div.card-body h2:has-text('New Customer')").textContent();
//		String header=page.locator("text=New Customer").textContent();
		System.err.println(header);
		
		page.close();
		browserContext.close();
		browser.close();
		playwright.close();
	}
	

}
