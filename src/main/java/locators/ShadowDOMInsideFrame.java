package locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowDOMInsideFrame {
	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		
		//page--> DOM--> Frame--> ShadowDOM--> Element
		
		page.navigate("https://selectorshub.com/xpath-practice-page/");
		page.frameLocator("#pact").locator("#tea").fill("Yes");
		

	}

}
