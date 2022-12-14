package playwrightBasics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class NthElementSelector {
	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page=browser.newPage();	
		page.navigate("https://www.bigbasket.com/");
		
		Locator firstLink = page.locator("div.container.footer-links li a >> nth=0");
		String first_Link = firstLink.textContent();
		System.out.println(first_Link);
		
		Locator lastLink = page.locator("div.container.footer-links li a >> nth=-1");
		String last_Link = lastLink.textContent();
		System.out.println(last_Link);
		lastLink.click();

	}

}
