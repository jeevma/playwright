package playwrightsessions;

import com.microsoft.playwright.*;

public class BrowserContextConcept {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext brcx1 = browser.newContext();
        Page p1 = brcx1.newPage();
        p1.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/");
        p1.fill("#Form_getForm_Name", "sanjiv mathur");
        System.out.println("Page title is: " + p1.title());

        BrowserContext brcx2 = browser.newContext();
        Page p2 = brcx2.newPage();
        p2.navigate("https://naveenautomationlabs.com/opencart/");
        p2.fill("//input[@name = 'search']", "iphone");
        System.out.println("Page title is: " + p2.title());
    }
}
