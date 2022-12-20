package testGenerator;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

public class Example2 {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page=context.newPage();
      page.navigate("https://testautomationpractice.blogspot.com/");
      page.frameLocator("#frame-one1434677811").getByLabel("First Name").click();
      page.frameLocator("#frame-one1434677811").getByLabel("First Name").fill("Ganesh");
      page.frameLocator("#frame-one1434677811").getByLabel("First Name").press("Tab");
      page.frameLocator("#frame-one1434677811").getByLabel("Last Name").fill("Poul");
      page.frameLocator("#frame-one1434677811").getByLabel("Phone").click();
      page.frameLocator("#frame-one1434677811").getByLabel("Phone").click();
      page.frameLocator("#frame-one1434677811").getByLabel("Phone").press("PageUp");
      page.frameLocator("#frame-one1434677811").getByLabel("Phone").press("ArrowUp");
      page.frameLocator("#frame-one1434677811").getByLabel("Phone").press("PageUp");
      page.frameLocator("#frame-one1434677811").getByLabel("Phone").press("NumLock");
      page.frameLocator("#frame-one1434677811").getByLabel("Phone").fill("9876543210");
      page.frameLocator("#frame-one1434677811").getByLabel("Phone").press("Tab");
      page.frameLocator("#frame-one1434677811").getByLabel("Country").fill("India");
      page.frameLocator("#frame-one1434677811").getByLabel("Country").press("Tab");
      page.frameLocator("#frame-one1434677811").getByLabel("City").fill("Delhi");
      page.frameLocator("#frame-one1434677811").getByLabel("City").click();
      page.frameLocator("#frame-one1434677811").getByLabel("City").fill("Delhi");
      page.frameLocator("#frame-one1434677811").getByLabel("City").press("Tab");
      page.frameLocator("#frame-one1434677811").getByLabel("Email Address").fill("abc@gmail.com");
      page.frameLocator("#frame-one1434677811").getByRole(AriaRole.CELL, new FrameLocator.GetByRoleOptions().setName("⚪ Male")).getByText("Male").click();
      page.frameLocator("#frame-one1434677811").getByText("Monday").click();
      page.frameLocator("#frame-one1434677811").getByText("Tuesday").click();
      page.frameLocator("#frame-one1434677811").getByText("Wednesday").click();
      page.frameLocator("#frame-one1434677811").getByText("Thursday").click();
      page.frameLocator("#frame-one1434677811").getByText("Friday").click();
      page.frameLocator("#frame-one1434677811").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Submit")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Home")).click();
    }
  }
}