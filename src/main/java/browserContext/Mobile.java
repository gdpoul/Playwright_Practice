package browserContext;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Mobile {
	public static void main(String[] args) {
	    try (Playwright playwright = Playwright.create()) {
	      Browser browser = playwright.chromium().launch(new BrowserType
	    		  .LaunchOptions().setHeadless(false));
	      BrowserContext context = browser.newContext(new Browser.NewContextOptions()
	        .setUserAgent("Mozilla/5.0 (Linux; Android 8.0; Pixel 2 Build/OPD3.170816.012) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3765.0 Mobile Safari/537.36")
	        .setViewportSize(411, 731)
	        .setDeviceScaleFactor(2.625)
	        .setIsMobile(true)
	        .setHasTouch(true));
	      Page page = context.newPage();
	      page.navigate("https://www.openstreetmap.org/");
//	      page.click("a[data-original-title=\"Show My Location\"]");
	      page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("colosseum-pixel2.png")));
	    }
	  }

}
