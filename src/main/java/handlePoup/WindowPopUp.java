package handlePoup;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WindowPopUp {
	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext brcx = browser.newContext();

		Page page = brcx.newPage();
		page.navigate("https://testautomationpractice.blogspot.com/");

		// 1.  open new blank tab/window popup and enter new url
		Page popup = page.waitForPopup(() -> {
			page.click("a[target='_blank']");
		});
		popup.waitForLoadState();
		popup.navigate("https://www.google.com");
		System.out.println("Popup Titile is: "+popup.title());

		// 2. open new tab.window/popup after clicking on link on parent page
//		Page popup=page.waitForPopup(() -> {
//			page.click("//img[@class='wikipedia-icon']");
//		});
//		
//		System.out.println("PopUp window title: "+popup.title());
//		popup.close();
//		
//		System.out.println("Parent window title: "+page.title());
//		page.close();

	}

}
