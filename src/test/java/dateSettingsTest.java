import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tester.Session;
import tester.TheMasterVariables;
import tester.UserSettings;

import java.util.Optional;


public class dateSettingsTest {


        @Test
        public void testingDateFormats(){
            TheMasterVariables variables = new TheMasterVariables("http://www.localhost:5000/","tj@saepiox.com","pass","chrome","Charles Ponzi",
                    "ASSET_MANAGER", Optional.of("C:\\Tests\\FileUpload1.exe"),Optional.of("C:\\Tests\\FileUpload2.exe"),Optional.of("anEmail@mail.com"),
                    Optional.of("@TerriblePass1"),Optional.of("Bad User"),"C:\\screenshots\\");

            ChromeDriver driver = new ChromeDriver();
            Session session = new Session();
            session.admin(driver, variables);
         //   UserSettings.dateCheck(driver);
        }@After
        public void teardown() {
        }
    }


