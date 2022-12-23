package locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class GetByRole {
	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));	
		Page page=browser.newPage();
		
		// Locate by using Role	
			
		page.navigate("https://opensource-demo.orangehrmlive.com/");
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions()
				.setName("Login")).click();
		
		
//		page.navigate("https://demoqa.com/links");
//		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().
//				setName("Home")).nth(1).click();

//		page.navigate("http://autopract.com/selenium//form5/");
//		page.getByRole(AriaRole.CHECKBOX, new Page.GetByRoleOptions().setName("Four")).click();
		
		
		page.close();
		browser.close();
		playwright.close();
	}

}
