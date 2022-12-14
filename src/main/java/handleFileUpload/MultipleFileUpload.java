package handleFileUpload;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MultipleFileUpload {
	public static void main(String[] args) throws InterruptedException {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		
		page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
		
		// make sure input type = file, then only playwright will handle file upload
		
		// Multiple file:
		
		page.setInputFiles("input#filesToUpload",
				new Path[] {
						Paths.get("NivodaLogin.json"),
						Paths.get("C:\\Users\\ganes\\OneDrive\\Pictures\\Screenshots\\Screenshot (54).png")});
		
		Thread.sleep(3000);
		page.setInputFiles("input#filesToUpload", new Path[0]);

	}

}
