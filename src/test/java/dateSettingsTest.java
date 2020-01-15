import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tester.Session;
import tester.UserSettings;
import tester.theVariables;

public class dateSettingsTest {


        private static WebDriver driver;
        @Before
        public void setup(){



            theVariables.setAdminPass("pass");
            theVariables.setAdminlogin("tj@saepiox.com");
        }
        @Test
        public void testingDateFormats(){
            driver = new ChromeDriver();

            Session.admin(driver);
            UserSettings.dateCheck(driver);
        }@After
        public void teardown() {
            driver.close();
        }
    }


