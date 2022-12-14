package handleFileUpload;

import java.nio.charset.StandardCharsets;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FilePayload;

public class CreateFileAndUpload {
	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://cgi-lib.berkeley.edu/ex/fup.html");
		
		// run time file upload
		page.setInputFiles("input[name='upfile']", new FilePayload(
				"ganesh.txt","text/plain", "this is ganesh here".getBytes(StandardCharsets.UTF_8)));
		
//		page.click("input[value='Press']");
	}

}
