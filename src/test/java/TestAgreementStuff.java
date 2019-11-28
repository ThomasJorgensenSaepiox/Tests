import com.google.common.annotations.VisibleForTesting;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import tester.Agreement;
import tester.Login;
import tester.testingVariablesPile;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class TestAgreementStuff {
    private static  WebDriver driver;


    @Before
    public void testSetup(){
        testingVariablesPile.setAdminPass("pass");
        testingVariablesPile.setAdminlogin("tm@saepiox.com");

    }

    @Test
    public void testCreate() throws InterruptedException {
        driver = new ChromeDriver();

        System.out.println("logging in on admin");
        Login.admin(driver);
        System.out.println("creating agreement");
        Agreement.createAndDestroyAgreement(driver);

    }
@After
public void testDestroy(){

    driver.quit();
}

}
