package handlePoup;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class JSpopUpPrompt {
	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page=browser.newPage();
		page.onDialog(dialog ->{
			dialog.accept("Hi, This is My Alert");
			
		});
		
		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		page.click("//button[text()='Click for JS Prompt']");
		
		String result = page.textContent("#result");
		System.out.println(result);


		page.close();
		browser.close();
		playwright.close();

	}

}
