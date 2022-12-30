package automaticLogin;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class OpencartLogin {
	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext brwContext=browser.newContext();
		Page page=brwContext.newPage();
		
		page.navigate("https://naveenautomationlabs.com/opencart/");
		page.locator("text=My Account").first().click();
		page.locator("text=Login").click();
		page.getByPlaceholder("E-Mail Address").fill("naveenanimation20@gmail.com");
		page.fill("#input-password", "Selenium@12345");
		page.click("input[value='Login']");
		
		brwContext
		  .storageState(new BrowserContext.StorageStateOptions()
				  .setPath(Paths.get("./login/opencartLogin.json")));
	}

}
