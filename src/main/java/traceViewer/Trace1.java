package traceViewer;


import java.nio.file.Paths;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

public class Trace1 {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      
      // Start tracing before creating / navigating a page.
      context.tracing().start(new Tracing.StartOptions()
      .setScreenshots(true)
      .setSnapshots(true));
      Page page = context.newPage();
      page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
      page.getByPlaceholder("Username").click();
      page.getByPlaceholder("Username").fill("Admin");
      page.getByPlaceholder("Password").click();
      page.getByPlaceholder("Password").fill("admin123");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Admin")).click();
      page.getByText("Job").click();
      page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Job Titles")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Add")).click();
      page.getByRole(AriaRole.TEXTBOX).nth(1).click();
      page.getByRole(AriaRole.TEXTBOX).nth(1).fill("SDET");
      page.getByPlaceholder("Type description here").click();
      page.getByPlaceholder("Type description here").fill("Test Engineer");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cancel")).click();
      page.getByText("Paul Collings").click();
      page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Logout")).click();
      
      // Stop tracing and export it into a zip archive.
      context.tracing().stop(new Tracing.StopOptions()
        .setPath(Paths.get("trace.zip")));
    }
  }
}
