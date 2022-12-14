package playwrightBasics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class CommaSepratedCSS1 {
	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		
		// Comma-SepratedCSS if getting changed
		
		page.navigate("https://academy.naveenautomationlabs.com/");
		
		page.locator("a:has-text('Login'),"
				+ "a:has-text('Signin'),"
				+ "a:has-text('LogIn'),"
				+ "a:has-text('SignIn')").click();
		
		
		
	}

}
