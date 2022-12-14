package FrameHandling;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FrameHandle1 {

	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		
		// Frame Handle
		page.navigate("http://londonfreelance.org/courses/frames/index.html");
		String headerText = page.frameLocator("//frame[@name='main']").locator("h2").textContent();
//		String headerText =page.frame("main").locator("h2").textContent();
		System.out.println(headerText);
		
	    browser.close();
	    playwright.close();

	}
}
