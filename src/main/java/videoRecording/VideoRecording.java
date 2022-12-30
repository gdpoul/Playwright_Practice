package videoRecording;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VideoRecording {
	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext context=browser
				         .newContext(new Browser.NewContextOptions()
				         .setRecordVideoDir(Paths.get("VideoRecording/"))
				         .setRecordVideoSize(1000, 570));
		
        Page page=context.newPage();
        page.navigate("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(2000);
        page.getByPlaceholder("Username").fill("Admin");
        Thread.sleep(2000);
        page.getByPlaceholder("Password").fill("admin123");
        Thread.sleep(2000);
        page.click("button:text('Login')");
        
        page.click("p.oxd-userdropdown-name");
        Thread.sleep(2000);
        page.click("a:text('Logout')");
        Thread.sleep(2000);
        
        
        context.close();
        page.close();
        playwright.close();

	}
}
