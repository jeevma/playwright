package playwrightsessions;

import com.microsoft.playwright.*;

public class Locators {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext bc = browser.newContext();
        Page page = bc.newPage();

        page.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/");

        // Locator contactSales = page.locator("text= CONTACT SALES").last();  //priority will be given to the text that appears on the web page
        //contactSales.hover();
        //contactSales.click();

        Locator countryOptions = page.locator("select#Form_getForm_Country option");
        System.out.println(countryOptions.count());
        for(int i =0; i<countryOptions.count(); i++){
            String text = countryOptions.nth(i).textContent();
            System.out.println(text);
        }

        browser.close();
    }
}
