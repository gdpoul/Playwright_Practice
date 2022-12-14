package playwrightBasics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HasElements {

	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		
		// Selecting elements that contains other elements
		
		page.navigate("https://www.amazon.com");
		Locator allFooterLink = page.locator("div.navFooterLinkCol:has(a[href='https://www.amazon.jobs'])");
		
		allFooterLink.allInnerTexts().forEach(e -> System.out.println(e));
	}
}
