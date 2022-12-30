package windowHandling;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleNewTab {

	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context=browser.newContext();
		Page page=context.newPage();		
		page.navigate("https://opensource-demo.orangehrmlive.com/");
		
		//open a new tab/window after clicking on link on the parent page
		
		Page popup = page.waitForPopup(() ->{
			page.click("//a[contains(@href,'twitter.com')]");
		});
		
		popup.waitForLoadState();
		
		System.out.println("Popup window title: "+popup.title());
		popup.close();
		
		System.out.println("Parent window title: "+page.title());
        page.close();
		

	}
}
