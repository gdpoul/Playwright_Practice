package browserContext;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserContextConcept {
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
	    BrowserContext context1 = browser.newContext();
	    Page page1 = context1.newPage();
	    page1.navigate("https://www.facebook.com");
	    page1.fill("#email", "Ganesh");
	    System.out.println(page1.title());
	    
	    Page page2 = context1.newPage();
	    page2.navigate("https://website-credits.nivodaapi.net/");
	    System.out.println(page2.title());

	    BrowserContext context2 = browser.newContext();
	    Page page3 = context2.newPage();
	    page3.navigate("https://opensource-demo.orangehrmlive.com/");
	    page3.getByPlaceholder("Username").fill("Admin");
	    System.out.println(page3.title());

	    BrowserContext context3 = browser.newContext();
	    Page page4 = context3.newPage();
	    page4.navigate("https://testautomationpractice.blogspot.com/");
	    page4.fill("#Wikipedia1_wikipedia-search-input","Playwright");
	    System.out.println(page4.title());

//	    context1.close();
//	    context2.close();
//	    context3.close();
	}

}
