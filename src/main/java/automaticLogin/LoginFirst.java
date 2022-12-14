package automaticLogin;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LoginFirst {
	public static void main(String[] args) {
		
		Playwright playwrigth=Playwright.create();
		Browser browser=playwrigth.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context=browser.newContext();
		
		Page page=context.newPage();
		page.navigate("https://opensource-demo.orangehrmlive.com/");
		page.getByPlaceholder("Username").fill("Admin");
		page.getByPlaceholder("Password").fill("admin123");
		page.click("button:text('Login')");
		
		context
		  .storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("orangeHrmLogin.json")));
		
	}

}
