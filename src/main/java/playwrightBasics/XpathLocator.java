package playwrightBasics;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class XpathLocator {
	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page=browser.newPage();	
		page.navigate("https://www.amazon.com");
		
		Locator allAmazonLinks=page.locator("//a[contains(text(),'Amazon')]");
		System.out.println(allAmazonLinks.count());

		List<String> textList = allAmazonLinks.allInnerTexts();
		System.out.println(textList.size());
	    textList.forEach(ele -> System.out.println(ele));
		
	}

}
