package videoRecording;

import java.nio.file.Paths;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VideoRecord3 {
	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext context=browser.newContext(
				new Browser.NewContextOptions().
				setRecordVideoDir(Paths.get("./VideoRecording/")).
				setRecordVideoSize(1000, 570));
		
		Page page=context.newPage();
		page.navigate("https://www.amazon.com/");
		page.fill("input#twotabsearchtextbox", "laptop");
		
	    page.locator(".s-suggestion").first().click();
	  
	    page.locator("div[id='brandsRefinements'] input").first().click();
	    System.out.println("Successfully click on brand ");
	    
//	    page.click("li[id='p_36/1253506011']");
//	    page.click("text=Windows 10 Pro");
	
//	    Locator result = page.locator("//div[@class='a-section']");
	    
    
//	    Locator results = page.locator("h2.a-size-mini");
//	    System.out.println(results.count());
	}

}
