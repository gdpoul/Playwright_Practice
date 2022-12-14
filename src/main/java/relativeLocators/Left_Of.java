package relativeLocators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Left_Of {
	
	// click on checkbox which is left to the Joe.Root
	static Page page;
	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page=browser.newPage();
		
		page.navigate("https://selectorshub.com/xpath-practice-page/");	
		
		selectUser("Joe.Root");
		selectUser("John.Smith");
		selectUser("Garry.White");
	}
	public static void selectUser(String userName) {
		page.locator("input[type='checkbox']:left-of(:text('"+userName+"'))").first().click();
	}

}
