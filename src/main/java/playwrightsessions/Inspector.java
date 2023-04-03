package playwrightsessions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class Inspector {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false).setSlowMo(500));
            BrowserContext context = browser.newContext();

            Page page = context.newPage();

            page.navigate("https://academy.naveenautomationlabs.com/");

            //page.getByRole("link", new Page.GetByRoleOptions().setName("Login")).click();

            page.locator("//a[contains(text(), 'Login')]").click();

            page.locator("").getByPlaceholder("Email").click();

            page.locator("form:has-text(\"Log In Email Password Forgot Password? Login Sign Up\")").getByPlaceholder("Email").fill("sanjeev.mathurr@gmail.com");

            //.click('text=Password');

            page.getByPlaceholder("Password").fill("Br@@ke123");

            page.getByPlaceholder("Password").press("Enter");
            assertThat(page).hasURL("https://academy.naveenautomationlabs.com/s/mycourses");

            /*
            page.getByRole("link", new Page.GetByRoleOptions().setName("library_books My Courses")).click();
            assertThat(page).hasURL("https://academy.naveenautomationlabs.com/s/mycourses");

            page.locator("label:has-text(\"account_circle Account\") i").nth(1).click();

            page.getByRole("link", new Page.GetByRoleOptions().setName("home Home")).click();
            assertThat(page).hasURL("https://academy.naveenautomationlabs.com/");

            page.getByRole("link", new Page.GetByRoleOptions().setName("")).click();

            page.getByRole("link", new Page.GetByRoleOptions().setName("Log Out")).click();
            assertThat(page).hasURL("https://academy.naveenautomationlabs.com/");

             */
        }
    }
}