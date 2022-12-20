package testGenerator;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class Debugging {
	public static void main(String[] args) throws InterruptedException {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			BrowserContext context = browser.newContext();
			Page page1 = context.newPage();
			page1.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
			// Login Operation
			page1.getByPlaceholder("Username").fill("Admin");
			page1.getByPlaceholder("Password").click();
			page1.getByPlaceholder("Password").fill("admin123");
			page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
			
			// click on Admin 
			page1.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Admin")).click();
			
			page1.pause();
			// Add the User
			page1.click("//button[normalize-space()='Add']");
			page1.getByText("-- Select --").first().click();
			page1.click("//span[text()='ESS']");
			page1.fill("//input[@placeholder='Type for hints...']", "David Morris");
			page1.getByText("David Morris").click();
			page1.getByText("-- Select --").click();
		    page1.click("//span[normalize-space()='Enabled']");
		    page1.getByRole(AriaRole.TEXTBOX).nth(2).fill("abcde");
		    page1.getByRole(AriaRole.TEXTBOX).nth(3).fill("Abcd@123");
		    page1.getByRole(AriaRole.TEXTBOX).nth(4).fill("Abcd@123");
			page1.click("//button[text()=' Save ']");
		    
		    Thread.sleep(5000);
			//search User
			page1.getByRole(AriaRole.TEXTBOX).nth(1).fill("abcde");
			page1.click("//button[@type='submit']");
			
			// Delete System User
			page1.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("")).locator("i").click();
			page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Delete Selected")).click();
			page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Yes, Delete")).click();

			// Logout 
			page1.locator("span").filter().click();
			page1.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Logout")).click();
		}
	}

}
