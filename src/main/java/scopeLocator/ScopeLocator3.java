package scopeLocator;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ScopeLocator3 {
	
	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.primefaces.org/primeng/table");

		Locator table = page.locator("table#pr_id_2-table tr");
		table.locator(":scope", new Locator.LocatorOptions()
				.setHasText(" Donette Foller "))
		        .locator("div[role='checkbox']")
		        .click();
		
		String balance = table.locator(":scope", new Locator.LocatorOptions()
				.setHasText(" Donette Foller "))
		        .locator("//td[6]")
		        .textContent();
		System.out.println(balance.substring(8));
	}


}
