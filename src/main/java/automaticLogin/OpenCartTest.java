package automaticLogin;

import java.nio.file.Paths;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class OpenCartTest {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext brwContext = browser.newContext(
				new Browser.NewContextOptions().setStorageStatePath(Paths.get("./login/opencartLogin.json")));

		Page page = brwContext.newPage();
		page.navigate("https://naveenautomationlabs.com/opencart/");

		Locator navHeaderOptions = page.locator("//ul[@class='nav navbar-nav']/li/a");
		for (int i = 0; i < navHeaderOptions.count(); i++) {

			String text = navHeaderOptions.nth(i).textContent();
			System.out.println(text);
		}
		page.click("//a[text()='View your order history']");
	}

}
