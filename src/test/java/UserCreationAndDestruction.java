import org.junit.Before;
import org.openqa.selenium.WebDriver;
import tester.*;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import tester.theVariables;
import tester.User;
public class UserCreationAndDestruction {
    private static WebDriver driver;
@Before
public void setup(){



        theVariables.setAdminPass("pass");
        theVariables.setAdminlogin("tj@saepiox.com");
     }
        @Test
        public void creating_user(){
    driver = new ChromeDriver();
        System.out.println("attempting creation and destruction of user");
        Session.admin(driver);
        User.auser(driver);
        Session.admin(driver);
        User.Delete_test_user(driver);
        }@After
        public void teardown() {
    driver.close();
    }
        }

