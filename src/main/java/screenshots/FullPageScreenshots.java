package screenshots;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FullPageScreenshots {
	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext context=browser.newContext();
		Page page=context.newPage();
		
		page.navigate("https://website-beta.nivodaapi.net/");
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./screenshots/screenshot1.png")));
		
		page.close();
		context.close();
		playwright.close();
		
	}

}
