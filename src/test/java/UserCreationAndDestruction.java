import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import tester.*;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import tester.User;

import java.util.Optional;

public class UserCreationAndDestruction {
    private static WebDriver driver;

    @Before
    public void setup() {


    }

    @Test
    public void creating_user() {
        TheMasterVariables variables = new TheMasterVariables("http://www.localhost:5000/", "tj@saepiox.com", "pass", "FireFox", "Charles Ponzi",
                "ASSET_MANAGER", Optional.of("C:\\Tests\\FileUpload1.exe"), Optional.of("C:\\Tests\\FileUpload2.exe"), Optional.of("anEmail@mail.com"),
                Optional.of("@TerriblePass1"), Optional.of("Bad User"), "C:\\screenshots\\");
        Session session = new Session();

        WebDriver driver = new FirefoxDriver();
        session.admin(driver, variables);
        User user = new User();
      Agreement agreement = new Agreement();
      agreement.Navigate_to_Agreement(driver,variables);
      agreement.createagreement(driver,variables);
        //  user.Navigate_to_user(driver, variables);
       // user.auser(driver, variables);
        //driver.close();
    }
}