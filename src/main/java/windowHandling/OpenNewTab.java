package windowHandling;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class OpenNewTab {
	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context=browser.newContext();
		Page page=context.newPage();		
		page.navigate("https://opensource-demo.orangehrmlive.com/");
		
		//open a new tab/window popup 
		
		Page newTab = page.waitForPopup(() ->{
			page.click("a[target='_blank']"); //open new tab window
		});
		
		newTab.waitForLoadState();
		newTab.navigate("https://www.google.com");
		newTab.fill("input[name='q']", "Playwright");
		System.out.println("title of new tab : "+newTab.title());
		newTab.close();
		
		System.out.println("parent window title: "+page.title());
		
		context.close();
		browser.close();
		playwright.close();
	}

}
