import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tester.Agreement;
import tester.Session;
import tester.theVariables;

public class TestAgreementStuff {
    private static  WebDriver driver;


    @Before
    public void testSetup(){
        theVariables.setAdminPass("pass");
        theVariables.setAdminlogin("tm@saepiox.com");

    }

    @Test
    public void testCreate() throws InterruptedException {
        driver = new ChromeDriver();

        System.out.println("logging in on admin");
        Session.admin(driver);
        System.out.println("creating agreement");
        Agreement.createAndDestroyAgreement(driver);

    }
@After
public void testDestroy(){

    driver.quit();
}

}
