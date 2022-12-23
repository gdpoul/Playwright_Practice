package locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class GetByPlaceholder {
	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));	
		
		Page page=browser.newPage();
		page.navigate("https://demoqa.com/text-box");
		page.getByPlaceholder("Full Name").fill("Ganesh Poul");

	}

}
