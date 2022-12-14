package playwrightBasics;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VisibleElement {

	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		
	
		page.navigate("https://www.amazon.com");
		List<String> linktexts = page.locator("a:visible").allInnerTexts();
		for(String s:linktexts) {
			System.out.println(s);
			
		}
		
	}
}
