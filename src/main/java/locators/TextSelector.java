package locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TextSelector {
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	  
	    Page page=browser.newPage();
	    page.navigate("https://demo.opencart.com/index.php?route=account/login");
	    
	    //text locators
	    Locator newCustomerHeader = page.locator("text=New Customer");
	    System.out.println(newCustomerHeader.textContent());
	    
	    Locator desktops = page.locator("ul a:has-text('Desktops')");
	    desktops.first().hover();
	    
	    page.locator("form a:has-text('Forgotten Password')").click();
	   
	    browser.close();
	    playwright.close();

	}

}
