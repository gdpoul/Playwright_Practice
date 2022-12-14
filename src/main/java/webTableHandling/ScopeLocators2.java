package webTableHandling;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ScopeLocators2 {
	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page=browser.newPage();
		page.navigate("https://www.primefaces.org/primeng/table");
		
		Locator row=page.locator("table#pr_id_2-table tr"); 
		row.locator(":scope",new Locator.LocatorOptions().setHasText("James Butt")).locator(".p-checkbox-box").click();

	}

}
