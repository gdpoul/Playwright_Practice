package browserContext;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Class2 {
	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();	    
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	    BrowserContext context = browser.newContext();
	    BrowserContext context1 = browser.newContext();
	    
	    Page page1 = context.newPage();
	    page1.navigate("https://website-beta.nivodaapi.net/");
	    page1.getByPlaceholder("Email").fill("ubaid@nivoda.net");
	    page1.getByPlaceholder("Password").fill("Nivoda123");
	    page1.locator("[aria-label='login-button']").click();
	    
	    Page page2 = context1.newPage();
	    page2.navigate("https://website-beta.nivodaapi.net/");
	    page2.getByPlaceholder("Email").fill("jonathon@brilliance.com");
	    page2.getByPlaceholder("Password").fill("Nivoda123");
	    Locator loginBtn = page2.locator("[aria-label='login-button']");
	    loginBtn.click();
	
	}

}
