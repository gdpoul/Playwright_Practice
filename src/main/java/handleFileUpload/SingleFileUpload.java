package handleFileUpload;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SingleFileUpload {
	public static void main(String[] args) throws InterruptedException {
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		
		page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
		
		// make sure input type = file, then only playwright will handle file upload
		
		// Select one file:
		page.setInputFiles("input#filesToUpload", Paths.get("orangeHrmLogin.json"));
		Thread.sleep(3000);
		
		// deselect the file
		page.setInputFiles("input#filesToUpload", new Path[0]);
	}

}
