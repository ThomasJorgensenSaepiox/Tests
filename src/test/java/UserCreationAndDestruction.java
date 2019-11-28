import org.junit.Before;
import org.openqa.selenium.WebDriver;
import tester.*;
import com.google.common.annotations.VisibleForTesting;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import tester.testingVariablesPile;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import tester.GenerateUser;
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
        GenerateUser.auser(driver);
        Login.admin(driver);
        GenerateUser.Delete_test_user(driver);
        }@After
        public void teardown() {
    driver.close();
    }
        }

