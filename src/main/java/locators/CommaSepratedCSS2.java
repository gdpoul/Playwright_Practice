package locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class CommaSepratedCSS2 {
	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		
		// Comma-SepratedCSS for validating multiple Element
		
		page.navigate("https://website-beta.nivodaapi.net/");
		
		Locator emp_Ele = page.locator(
				"a:has-text('Create Free Account'),"+ 
		        "img.blue-logo,"+ 
			    "h1:has-text('Log in to Nivoda')");
		
		System.out.println(emp_Ele.count());
		
		if(emp_Ele.count()==3) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		
	}

}
