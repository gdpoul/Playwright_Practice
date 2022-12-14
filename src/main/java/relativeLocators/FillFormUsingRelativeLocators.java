package relativeLocators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FillFormUsingRelativeLocators {
	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();	
		page.navigate("https://selectorshub.com/xpath-practice-page/");	
		
//		page.locator("input:below(label:text('User Email'))").first().fill("abc@gmail,com");
//		page.locator("input:below(label:text('Password'))").first().fill("abc123");
//		page.locator("input:below(label:text('Company'))").first().fill("Speckyfox");
//		page.locator("input:below(label:text('Mobile Number'))").first().fill("9876543214");
        
		boolean status = page.locator("//input[@id='userId']").isEditable();
		System.out.println(status);
	}

}
