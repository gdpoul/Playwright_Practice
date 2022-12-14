package relativeLocators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Right_Of {
	static Page page;
	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page=browser.newPage();	
		page.navigate("https://selectorshub.com/xpath-practice-page/");	
		
		System.out.println(userRole("John.Smith"));
		System.out.println(userRole("Kevin.Mathews"));
		

	}
	public static String userRole(String userName) {
		
		String role = page.locator("td:right-of(:text('"+userName+"'))").first().textContent();
		return role;
	}

}
