package multipleElements;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MultipleElement {
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	    BrowserContext context = browser.newContext();
	    
	    Page page=context.newPage();
	    page.navigate("https://testautomationpractice.blogspot.com/");
	    
//	    Multiple Element
	    Locator speedOptions = page.locator("select#speed option");
	    System.out.println(speedOptions.count());
	    
//	    for(int i=0;i<speedOptions.count();i++) {
//	    	String result = speedOptions.nth(i).textContent();
//	    	System.out.println(result);
//	    }
	    
	    List<String> allOptions = speedOptions.allTextContents();
//	    for(String s: allOptions) {
//	    	System.out.println(s);
//	    }
	    
	    allOptions.forEach(options -> System.out.println(options));
	    
	    context.close();
	    browser.close();
	    playwright.close();
	    
	}

}
