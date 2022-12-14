package automaticLogin;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestNivoda {
	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context=
			browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("NivodaLogin.json")));
		
		Page page=context.newPage();
		page.navigate("https://website-beta.nivodaapi.net/");
	}

}
