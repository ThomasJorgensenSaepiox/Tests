import org.junit.Before;
import org.openqa.selenium.WebDriver;
import tester.*;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import tester.testingVariablesPile;
import tester.User;
public class UserCreationAndDestruction {
    private static WebDriver driver;
@Before
public void setup(){



        testingVariablesPile.setAdminPass("pass");
        testingVariablesPile.setAdminlogin("tj@saepiox.com");
     }
        @Test
        public void creating_user(){
    driver = new ChromeDriver();
        System.out.println("attempting creation and destruction of user");
        Login.admin(driver);
        User.auser(driver);
        Login.admin(driver);
        User.Delete_test_user(driver);
        }@After
        public void teardown() {
    driver.close();
    }
        }

