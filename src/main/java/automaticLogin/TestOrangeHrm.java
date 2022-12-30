package automaticLogin;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestOrangeHrm {
	public static void main(String[] args) {
		 Playwright playwright=Playwright.create();
		 Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		 
		 BrowserContext context=
				 browser.newContext(new Browser.NewContextOptions()
						 .setStorageStatePath(Paths.get("./login/orangeHrmLogin.json")));
		 
		 Page page=context.newPage();
		 page.navigate("https://opensource-demo.orangehrmlive.com/");
		 
	}

}
