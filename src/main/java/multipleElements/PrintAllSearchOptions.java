package multipleElements;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PrintAllSearchOptions {

	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext browserContext=browser.newContext();
//		browserContext.setDefaultTimeout(60000);
		Page page =browserContext.newPage();
		page.navigate(" ",new Page.NavigateOptions().setTimeout(120000));
		page.locator("text=✕").click();
        page.fill("//input[@name='q']", "Mobiles");
        
        Locator allDynamicOptions = page.locator("//li[@class='Y5N33s']");
        System.out.println(allDynamicOptions.count());
        List<String> options = allDynamicOptions.allTextContents();
        
        options.forEach(ele -> System.out.println(ele));
        System.out.println("Hello");
        
        page.close();
        browserContext.close();
        browser.close();
        playwright.close();
	}
}
