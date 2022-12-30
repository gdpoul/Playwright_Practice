package windowHandling;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightTest {

	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext context=browser.newContext();
		Page page1=context.newPage();
		page1.navigate("https://playwright.dev/java/docs/intro");
		
		Page page2 = page1.waitForPopup(() -> {
			page1.click("//a[text()='Twitter']");
		});
		
		page2.waitForLoadState();
//		System.out.println(page2.title());
		System.out.println(page2.url());
		
		page2.locator("//a[@aria-label='Twitter']").
		    screenshot(new Locator.ScreenshotOptions().
		    		setPath(Paths.get("./screenshots/twitter_logo.png")));
		page2.close();
		System.out.println(page1.title());
		page1.close();
		
		context.close();
		browser.close();
		playwright.close();
		
	}
}
