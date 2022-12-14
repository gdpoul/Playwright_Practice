package relativeLocators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Above {
	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();	
		page.navigate("https://selectorshub.com/xpath-practice-page/");	
		
		String above_User= page.locator("a:above(:text('Joe.Root'))").first().textContent();
        System.out.println(above_User);
        
        String below_User =page.locator("a:below(:text('Joe.Root'))").first().textContent();
        System.out.println(below_User);

	}

}
