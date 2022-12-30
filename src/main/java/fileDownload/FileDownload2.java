package fileDownload;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FileDownload2 {
	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context=browser.newContext();
		Page page=context.newPage();
		page.navigate("https://www.selenium.dev/downloads/");
		
		Download file = page.waitForDownload(() -> {
			page.locator("//a[contains(@href,'selenium-server-4.7.2.jar')]").first().click();

		});
		
       file.saveAs(Paths.get("./DownloadFiles/selenium-server"));		
	}

}
