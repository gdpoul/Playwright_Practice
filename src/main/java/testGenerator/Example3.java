package testGenerator;

import com.microsoft.playwright.*;

public class Example3 {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext(new Browser.NewContextOptions()
        .setViewportSize(800, 600));
      Page page = context.newPage();
      page.navigate("http://playwright.dev/");
    }
  }
}
