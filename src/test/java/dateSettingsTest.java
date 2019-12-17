import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tester.GenerateUser;
import tester.Login;
import tester.UserSettings;
import tester.testingVariablesPile;

public class dateSettingsTest {


        private static WebDriver driver;
        @Before
        public void setup(){



            testingVariablesPile.setAdminPass("pass");
            testingVariablesPile.setAdminlogin("tj@saepiox.com");
        }
        @Test
        public void testingDateFormats(){
            driver = new ChromeDriver();

            Login.admin(driver);
            UserSettings.dateCheck(driver);
        }@After
        public void teardown() {
            driver.close();
        }
    }


