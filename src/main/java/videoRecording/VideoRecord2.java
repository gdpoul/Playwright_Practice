package videoRecording;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class VideoRecord2 {
	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//		BrowserContext browserContext=browser.newContext();
		
		BrowserContext browserContext = browser
				.newContext(new Browser.NewContextOptions()
			    .setRecordVideoDir(Paths.get("VideoRecording/"))
				.setRecordVideoSize(1000, 570));
		
		Page page=browserContext.newPage();
		page.navigate("https://testautomationpractice.blogspot.com/");
		FrameLocator lc = page.frameLocator("iframe#frame-one1434677811");
        lc.locator("input#RESULT_TextField-1").fill("David");
        lc.locator("input#RESULT_TextField-2").fill("Malan");
		lc.locator("input#RESULT_TextField-3").fill("1236547890");
		lc.locator("input#RESULT_TextField-4").fill("India");
		lc.locator("input#RESULT_TextField-5").fill("Delhi");
		lc.locator("input#RESULT_TextField-6").fill("abc@gmaill.com");
	    lc.getByRole(AriaRole.CELL, new FrameLocator.GetByRoleOptions()
	    		.setName("⚪ Male")).getByText("Male").click();
//		lc.locator("//input[@value='Radio-0']").click();
		
		int count = page.locator("//input[@type='checkbox']").count();
		for(int i=0;i<count;i++) {
			lc.locator("//input[@value='CheckBox-"+i+"']").click();
		}
		
		browserContext.close();
        page.close();
        playwright.close();

		
	}

}
