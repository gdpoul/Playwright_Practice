package locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class GetByAltText {
	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));	
		Page page=browser.newPage();
		
		// Locate By Using Alt Text
		page.navigate("https://opensource-demo.orangehrmlive.com/");	
		boolean status = page.getByAltText("orangehrm-logo").isVisible();
		System.out.println(status);
		
		
		browser.close();
		playwright.close();
	}

}
