package testGenerator;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

public class Example {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
      page.getByPlaceholder("Username").click();
      page.getByPlaceholder("Username").fill("Admin");
      page.getByPlaceholder("Password").click();
      page.getByPlaceholder("Password").fill("admin123");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
      page.getByPlaceholder("Search").click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Admin")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Leave")).click();
      page.locator(".oxd-date-input > .oxd-icon").first().click();
      page.locator("form").getByText("11").click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search")).click();
    }
  }
}