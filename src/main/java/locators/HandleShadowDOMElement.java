package locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleShadowDOMElement {
	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		//page--> DOM--> shadowDOM--> Element
		
		Page page=browser.newPage();
		page.navigate("https://books-pwakit.appspot.com/");
//      page.fill("input#input","Testing Books");
		page.locator("book-app[apptitle='BOOKS'] #input").fill("Testing Books");
		String text=page.locator("book-app[apptitle='BOOKS'] .books-desc").textContent();
        System.out.println(text);
		
	}
}
