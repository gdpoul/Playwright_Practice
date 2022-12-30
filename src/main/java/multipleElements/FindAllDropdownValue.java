package multipleElements;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FindAllDropdownValue {
	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext browserContext=browser.newContext();
		Page page =browserContext.newPage();	
		page.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		Locator countryOptions = page.locator("select#Form_getForm_Country option");
		System.out.println(countryOptions.count());
		
//	    for(int i=0;i<countryOptions.count();i++) {
//	    	String text = countryOptions.nth(i).textContent();
//	    	System.out.println(text);
//	    }
		
		List<String> allOptions = countryOptions.allInnerTexts();
		allOptions.forEach(ele ->System.out.println(ele));
		
      page.close();
      browserContext.close();
      browser.close();
      playwright.close();

	}

}
