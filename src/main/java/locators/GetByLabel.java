package locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class GetByLabel {
	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));		
		Page page=browser.newPage();	
		page.navigate("http://autopract.com/selenium//form5/");
		
		// Locate by using label
		page.getByLabel("Two").click();
	}

}
