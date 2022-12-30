package handleFileUpload;

import java.nio.file.Paths;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class UploadFile1{
	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context=browser.newContext();
		Page page=context.newPage();
		page.navigate("https://www.foundit.in/seeker/registration");
		
		page.setInputFiles("input#file-upload", Paths.get("D:\\Selenium\\Selenium Grid\\Grid_Command.txt"));
		System.out.println("File Upload successfully");
	}

}
