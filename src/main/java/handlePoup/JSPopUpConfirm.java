package handlePoup;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class JSPopUpConfirm {

	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		// playwright listner which will be running in background
		Page page=browser.newPage();
		page.onDialog(dialog -> {
			String text=dialog.message();
			System.out.println(text);
			System.out.println(dialog.type());
			dialog.accept();
		});
		
		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		page.click("//button[text()='Click for JS Confirm']");
		
		String result = page.textContent("#result");
		System.out.println(result);


		page.close();
		browser.close();
		playwright.close();
	}
}
