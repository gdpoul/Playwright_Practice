package locators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class GetByText {
	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));	
		
		Page page=browser.newPage();
		page.navigate("https://demoqa.com/automation-practice-form");
		
        // Locate By Using Text
        page.getByText("Male").nth(1).click();
        page.fill("input#userNumber", "9876543210");
        page.locator("#dateOfBirthInput").click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions()
        		.setName("Choose Friday, December 30th, 2022")).click();
        
        page.getByText("Reading").click();

	}

}
