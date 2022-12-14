package relativeLocators;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Near {
	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();	
		page.navigate("https://selectorshub.com/xpath-practice-page/");	
		
		List<String> nearWebElement = page.locator("td:near(:text('Joe.Root'), 150)").allInnerTexts();
		
		nearWebElement.forEach(ele ->System.out.println(ele));

	}

}
